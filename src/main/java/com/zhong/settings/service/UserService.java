package com.zhong.settings.service;

import com.zhong.settings.Exception.LoginException;
import com.zhong.settings.domain.User;

public interface UserService {


    User userLogin(String loginAct,String loginPwd ,String ip) throws LoginException;

}
