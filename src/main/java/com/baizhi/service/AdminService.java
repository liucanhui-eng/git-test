package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    Admin login(String name, String password)throws Exception;
    void updaKey(String name, String newPassword);
}
