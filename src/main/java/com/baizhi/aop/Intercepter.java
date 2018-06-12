package com.baizhi.aop;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.dao.DemoLogDao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.DemoLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Configuration()
public class Intercepter {
    Logger logger= LoggerFactory.getLogger(Integer.class);

    @Autowired
    DemoLogDao dao;
    //@Pointcut(value = "@annotation(com.baizhi.annotation.LogAnnotation)")

    @Around(value = "@annotation(com.baizhi.annotation.LogAnnotation)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("=================进入事务====================================");

        Object proceed=null;
        DemoLog log = new DemoLog();

        //what?
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String what = method.getAnnotation(LogAnnotation.class).name();
        try {
            proceed= proceedingJoinPoint.proceed();
            log.setResult("成功");
        } catch (Throwable throwable) {
            log.setResult("失败");
            throwable.printStackTrace();
        }
        //who？;
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String who=admin.getName();


        log.setAdmin(who);
        log.setDate(new Date());
        log.setOperation(what);
        dao.insert(log);
        return proceed;
    }


}
