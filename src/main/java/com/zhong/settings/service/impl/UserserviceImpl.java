package com.zhong.settings.service.impl;

import com.zhong.settings.dao.UserDao;
import com.zhong.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserDao userDao;




}
