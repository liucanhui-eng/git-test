package com.baizhi.service;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    @LogAnnotation(name = "登陆操作")
    public Admin login(String name, String password)throws Exception {
        Admin admin = adminDao.queryByName(name);
        if(admin==null)
            throw new RuntimeException("用户名不存在");
        if(!admin.getPassword().equals(password))
            throw new RuntimeException("密码错误");

        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("admin",admin);
        System.out.println("登陆成功"+session.getAttribute("admin"));
        return admin;
    }

    @Override
    public void updaKey(String name,String newPassword) {
        adminDao.updateKey(name,newPassword);
    }
}
