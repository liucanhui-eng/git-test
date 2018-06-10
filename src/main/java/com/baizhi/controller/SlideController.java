package com.baizhi.controller;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideService;

import com.baizhi.util.UploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value = "slide", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SlideController {
    @Autowired
    SlideService service;

    @RequestMapping(value = "showAll")
    @ResponseBody
    public Object SlideShow() {
        return service.showAll();
    }

    @RequestMapping(value = "update")
    public void Update(SlideShow slideShow) {
        System.out.println(slideShow);
        service.update(slideShow);
    }

    @ResponseBody
    @RequestMapping(value = "delete")
    public String Delete(SlideShow slideShow) {
        System.out.println(slideShow);
        service.delete(slideShow.getId());
        return "success";
    }


    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(MultipartFile img, String title, String ms, HttpServletRequest request) {
        //上传文件
        Map<String, String> map = UploadUtil.upload(img, UploadUtil.IMG, request);

        String url=map.get("url");
        String tail=map.get("tail");
        SlideShow slideShow = new SlideShow();
        slideShow = slideShow.setParam(title, url, ms, tail);
        System.out.println(slideShow );
        service.add(slideShow);
        return "success";

    }


}
