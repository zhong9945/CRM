package com.zhong.settings.service.impl;

import com.zhong.settings.Exception.LoginException;
import com.zhong.settings.dao.UserDao;
import com.zhong.settings.domain.User;
import com.zhong.settings.service.UserService;
import com.zhong.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User userLogin(String ip,String loginAct, String loginPwd) throws LoginException {
        User user = userDao.queryUser(loginAct,loginPwd);
        //等于空 说明没查到了对象
        if(user==null) {
            throw new LoginException("账号密码错误");
        }
        if("0".equals(user.getLockState())){
            throw  new LoginException("账号已被锁定");
        }
        //获取系统当前时间
        String date = DateTimeUtil.getFormatSystemTime();
        if(date.compareTo(user.getExpireTime())<0){
            throw new LoginException("账号已过期");
        }
        //查询ip是否在允许范围内
        if(!user.getAllowIps().contains(ip)){
            throw new LoginException("ip被限制");
        }
        //程序执行到这里  说明该账号没有任何问题  直接返回该对象
        return user;
    }
}
