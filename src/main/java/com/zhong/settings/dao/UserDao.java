package com.zhong.settings.dao;


import com.zhong.settings.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

     User queryUser(String loginAct, String loginPwd);


}
