package com.baizhi.controller;

import com.baizhi.entity.DataModel;
import com.baizhi.entity.User;
import com.baizhi.entity.WenData;
import com.baizhi.service.FrontService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(method = RequestMethod.GET)

public class FirstPage {
    @Autowired
    FrontService frontService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "FirstPage")
    @ResponseBody
    public DataModel FirstPage(String uid, String type, String sub_type){
        if ((type!=null)&&(type.equals("all")))
            return  frontService.firstPage();
        return null;
    }

    @RequestMapping(value = "wen")
    @ResponseBody
    public WenData wen(String uid, String id){
        System.out.println("id="+id);
        if ((id!=null)) {
            return frontService.albumDetail(id);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET,value = "login")
    @ResponseBody
    public Object login(String phone, String password,String code ){
        System.out.println("================"+phone);
        return userService.queryByTel(phone,password);
    }




}
