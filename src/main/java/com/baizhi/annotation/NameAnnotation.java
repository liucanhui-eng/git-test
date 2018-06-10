package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//定义位置
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface NameAnnotation {
    public String name();
}
