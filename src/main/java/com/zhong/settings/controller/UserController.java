package com.zhong.settings.controller;


import com.zhong.settings.domain.User;
import com.zhong.settings.service.UserService;
import com.zhong.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/settings")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public ModelAndView loginVerification(HttpServletRequest request, String loginAct , String loginPwd){
        ModelAndView mv = new ModelAndView();
        String password = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        try{
            //能得到对象就说明该账号可用
            User  user = userService.userLogin(loginAct,password,ip);
//            //创建session对象
//            request.getSession().setAttribute("user",user);
            //需要返回{"success",ture}
            mv.addObject("success",true);

            return mv;
        }
        catch (Exception e){
            e.printStackTrace();
            //抛出异常  需要返回{"success":false,"message":"?"}
            mv.addObject("success",false);
            mv.addObject("msg",e.getMessage());

            return  mv;
        }




    }











}
