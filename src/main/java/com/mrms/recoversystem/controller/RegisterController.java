package com.mrms.recoversystem.controller;

import com.github.pagehelper.PageInfo;
import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.model.Register;
import com.mrms.recoversystem.service.RegisterService;
import com.mrms.recoversystem.util.GenerateNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: recoversystem
 * @description: 挂号单业务逻辑
 * @author: Luhaojian
 * @create: 2018-12-14 12:03
 **/
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /*
     * @Author luhaojian
     * @Description //TODO MRMS_Collector_Register_List.html 添加挂号信息
     * @Date 16:51 2019/3/2
     * @Param [register]
     * @return java.lang.Boolean
     **/
    @PostMapping("addRegister")
    @ResponseBody
    public Boolean addRegister(Register register){
        return registerService.addRegister(register);
    }

    /*
     * @Author luhaojian
     * @Description //TODO 找出当天所有的挂号单信息，如果需要的话可以查看某个收费员开具的当天的所有挂号单信息
     * @Date 9:27 2019/3/1
     * @Param [tollCollector]
     * @return java.util.Map<java.lang.String,com.github.pagehelper.PageInfo<com.mrms.recoversystem.model.Register>>
     **/
    @ResponseBody
    @RequestMapping("findRegistersByTollCollector")
    public Map<String, PageInfo<Register>> registerList(int pageNum , int pageSize){
        Map<String, PageInfo<Register>> map = new HashMap<>();
        List<Register> list = registerService.findRegisterList(pageNum,pageSize);
        PageInfo<Register> pages = new PageInfo<>(list);
        map.put("registers",pages);
        return map;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 通过挂号单号搜索挂号单信息
     * @Date 16:53 2019/2/28
     * @Param [registerId]
     * @return com.mrms.recoversystem.model.Register
     **/
    @ResponseBody
    @RequestMapping("findRegistersById")
    public Register findRegisterByRegisterId(String registerId){
        Register register = new Register();
        register.setRegisterId(registerId);
        Register result = registerService.findRegister(register);
        if (result==null)
            System.out.println("result is null-----------");
        System.out.println(result.toString());
        return result;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 根据挂号单编号删除已取消的挂号单
     * @Date 16:48 2019/2/28
     * @Param [registerId]
     * @return java.lang.Boolean
     **/
    @PostMapping("deleteRegister")
    @ResponseBody
    public Boolean cancelRegister(String registerId){
        Register register = new Register();
        boolean flag = registerService.delete(registerId);
        if (flag)
            return true;
        else return false;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 医生查看待就诊的患者列表
     * @Date 16:49 2019/2/28
     * @Param [doctorId, visStatus]
     * @return java.util.Map<java.lang.String,java.util.List<com.mrms.recoversystem.model.Register>>
     **/
    @GetMapping("findRegistersByDoctorId")
    @ResponseBody
    public Map<String, List<Register>> findRegistersByDoctorId(Integer doctorId,Integer visStatus){
        System.out.println("进入findRegistersByDoctorId方法，doctorId = "+ doctorId+",visStatus = "+visStatus);
        Map<String, List<Register>> map = new HashMap<>();
        List<Register> list = registerService.findRegistersByDoctorId(doctorId,visStatus);
        map.put("registers",list);
        return map;
    }
}

