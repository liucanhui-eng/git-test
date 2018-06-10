package com.baizhi.service;


import com.baizhi.entity.DataModel;
import com.baizhi.entity.WenData;

public interface FrontService {
    //首页服务
    DataModel firstPage();
    //闻页面
    WenData albumDetail(String id);
}
