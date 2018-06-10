package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Audio;
import com.baizhi.entity.ComboboxData;
import com.baizhi.service.AudioAndAlbumService;
import com.baizhi.util.UploadUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping(value = "tree")
public class AudioAndAlbumController {
    @Autowired
    AudioAndAlbumService service;

    @RequestMapping(value = "/showAlbum")
    @ResponseBody
    public Object showAlbum() {//
        System.out.println(service.showAll());
        return service.showAll();
    }


    @RequestMapping(value = "/addAlbum")
    @ResponseBody
    public String addAlbum(MultipartFile albumImg, String albumName, String albumAuthor,
                           String albumAnnouncer, String albumMs, HttpServletRequest request) {


        Map<String, String> map = UploadUtil.upload(albumImg, UploadUtil.IMG, request);

        Album album = Album.setParam(albumName, map.get("url"), albumAuthor, albumAnnouncer, albumMs);
        service.addAlbum(album);

        System.out.println("\n\n============================================================\n\n");
        System.out.println("albumName:  " + albumName + "\nalbumAuthor:  " + albumAuthor);
        System.out.println("albumMs: " + albumMs + "\nalbumImg: " + albumImg + "\nalbumAnnouncer: " + albumAnnouncer);
        System.out.println("album:   " + album);
        System.out.println("\n\n============================================================\n\nt");

        return "success";
    }


    @RequestMapping(value = "/getComboboxData")
    @ResponseBody
    public List<ComboboxData> getComboboxData() {
        List<ComboboxData> list = new ArrayList<>();
        for (Album album : service.showAll()) {
            list.add(new ComboboxData(album.getId(), album.getTitle()));
        }
        return list;
    }


    @RequestMapping(value = "/keepAudio")
    @ResponseBody
    public String keepAudio(MultipartFile audioFile, String albumId, HttpServletRequest request) {


        Map<String, String> map = UploadUtil.upload(audioFile, UploadUtil.MP3, request);

        String downPath = map.get("url");
        String size = audioFile.getSize() / 1000000 + "";

        Audio audio = Audio.SetParam(audioFile.getOriginalFilename(), size, downPath, albumId, "2:30");

        service.addAudio(audio);


        System.out.println("\n\n============================================================\n\n");
        System.out.println("audioFile:  " + audioFile + "\naudioTitle:  " + albumId);
        System.out.println(audio);
        System.err.println(audioFile.getSize() + "**********\n" + audioFile.getOriginalFilename());
        System.out.println("\n\n============================================================\n\nt");

        return "success";

    }

    @RequestMapping(value = "/upload")
    public void upload(String id,HttpServletResponse response,HttpServletRequest request) throws Exception{

        Audio audio = service.selectUploadPath(id);
        //第一步：设置响应类型
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        //设置响应头，对文件进行url编码
        String  name = URLEncoder.encode(audio.getTitle(),"utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+name);
        //response.setContentLength(in.available());


        System.out.println("id==="+id);


        try {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File file=new File(realPath);
            realPath=file.getParent();

            IOUtils.copy(new FileReader(realPath+audio.getDownPath()),response.getWriter());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
