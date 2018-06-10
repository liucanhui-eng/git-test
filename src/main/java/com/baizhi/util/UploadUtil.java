package com.baizhi.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UploadUtil {
    public static final String IMG="IMG";
    public static final String MP3="MP3";

    public static Map<String,String> upload(MultipartFile file, String type, HttpServletRequest request){



        //重命名
        String filename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replace("-", "");
        String tail = FilenameUtils.getExtension(filename);
        newName=newName+"."+tail;
        //创建目录
        //获取目录
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file1 = new File(realPath);
        //新目录
        String newPath=file1.getParent();
        String dir=null;
        if(IMG.equals(type))
            dir="\\upload"+"\\img";
        if(MP3.equals(type))
            dir="\\upload"+"\\mp3";
        newPath=newPath+dir;
        File f=new File(newPath);

        if(!f.exists()){
            System.out.println("===========");
            f.mkdir();
        }

        try {
            file.transferTo(new File(newPath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<String,String> map=new HashMap<>();
        map.put("url",dir+"\\"+newName);
        map.put("tail",tail);

        System.out.println("\n\n=====================上传成功==========================\n");
        System.out.println("上传路径："+newPath+"\n文件名："+newName);
        System.out.println("\n======================上传成功=========================\n\n");



        return map;
    }
}
