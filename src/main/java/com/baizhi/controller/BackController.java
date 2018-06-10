package com.baizhi.controller;//package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "back")
@SessionAttributes(types={Admin.class},value = {"admin"})
public class BackController {
    @Autowired
    AdminService service;
    @ResponseBody
    @RequestMapping(value = "login")
    public String login(Admin admin) {
        try {
            service.login(admin.getName(), admin.getPassword());
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }

    }



    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest request, SessionStatus sessionStatus) {
        request.getSession().invalidate();
        sessionStatus.setComplete();
        return "redirect:/slide.jsp";
    }

}
