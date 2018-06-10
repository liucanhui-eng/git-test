package com.baizhi.aop;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.dao.DemoLogDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.DemoLog;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

public class Intercepter implements MethodInterceptor {
    @Autowired
    DemoLogDao dao;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("===========开启日志======================");
        Object result = null;


        try {
            //日志对象
            DemoLog log = new DemoLog();

            //什么时间？
            log.setDate(new Date());



            //干了啥？
            Method method = invocation.getMethod();
            LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
            String operation = annotation.name();
            log.setOperation(operation);

            result = null;
            try {
                result = invocation.proceed();
                //结果如何？
                log.setResult("success");
            } catch (Throwable throwable) {
                //结果如何？
                log.setResult("field");
                //throwable.printStackTrace();
            }

            //谁？
            ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            HttpSession session = request.getSession();
            Object admin = session.getAttribute("admin");
            if(admin!=null && admin instanceof Admin){
                String name=((Admin)admin).getName();
                log.setAdmin(name);
            }
//            log.setAdmin("小明");



            dao.insert(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
