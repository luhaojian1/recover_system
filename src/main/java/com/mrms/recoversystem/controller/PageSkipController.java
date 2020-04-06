package com.mrms.recoversystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: recoversystem
 * @description:
 * @author: Luhaojian
 * @create: 2019-01-06 18:40
 **/
@Controller
public class PageSkipController {

    //登录页面
    @RequestMapping("/")
    public String login(){
        return "/html/login.html";
    }



}
