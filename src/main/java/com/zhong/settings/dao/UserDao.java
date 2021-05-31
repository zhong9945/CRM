package com.zhong.settings.dao;


import com.zhong.settings.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

     User queryUser(@Param(value = "loginAct") String loginAct, @Param(value = "loginPwd") String loginPwd);


}
