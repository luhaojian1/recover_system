package com.mrms.recoversystem.controller;

import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.service.MedicalpersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: recoversystem
 * @description: 登录
 * @author: Luhaojian
 * @create: 2018-12-11 09:50
 **/
@Controller
public class LoginController {
    @Autowired
    private MedicalpersonalService medicalpersonalService;


    @ResponseBody
    @GetMapping("loginVerification")
    public Map<String, Object> validateUserInfo(Integer userId, String passWord, HttpSession session) {
        System.out.println(userId + " " + passWord);
        Map<String, Object> map = new HashMap<>();
        Medicalpersonal user = medicalpersonalService.validateUserInfo(userId, passWord, session);
        if (user != null){
            map.put("userName", user.getUserName());
            map.put("url", "../html/MRMS_Collector_Register.html");
        }
        return map;
    }


    @RequestMapping("signOut")
    public String signOutSyetem(HttpSession session, HttpServletRequest request) {
        session.setAttribute("user", null);
        return "../html/login.html";
    }


}
