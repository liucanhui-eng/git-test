package com.baizhi.controller;

import com.baizhi.image.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public  class  ImageController{
    @RequestMapping(value = "getImage")
    public void getImage(HttpServletResponse response, HttpSession session){
        CreateValidateCode validateCode = new CreateValidateCode();
        String code=validateCode.getCode();
        System.out.println("生成的校验码："+code);
        session.setAttribute("code",code);
        System.out.println(session.getAttribute("code"));
        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "getCode")
    @ResponseBody
    public String getCode( HttpSession session){
        String code=(String) session.getAttribute("code");
        System.out.println("=====code==="+code);
        return code;
    }

}