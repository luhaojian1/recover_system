package com.mrms.recoversystem.controller;

import com.github.pagehelper.PageInfo;
import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.service.MedicalpersonalService;
import com.mrms.recoversystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: recoversystem
 * @description: 医疗人员控制层
 * @author: Luhaojian
 * @create: 2018-12-20 19:50
 **/
@Controller
public class MedicalpersonalController {
    @Autowired
    private MedicalpersonalService medicalpersonalService;
    @Autowired
    private RegisterService registerService;
    /*
     * @Author luhaojian
     * @Description //TODO 添加用户信息，创建新用户
     * @Date 16:15 2019/1/31
     * @Param [medicalpersonal]
     * @return java.lang.String
     **/
    @ResponseBody
    @PostMapping("addUser")
    public Boolean addUser(Medicalpersonal medicalpersonal) {
        System.out.println("enter addUser : medicalpersonal=" + medicalpersonal);
        if (medicalpersonal == null)
            return false;
        Boolean result = medicalpersonalService.add(medicalpersonal);
        System.out.println(result);
        return result;

    }

    /*
     * @Author luhaojian
     * @Description //TODO 通过搜索医生姓名或职位来寻找医生
     * @Date 16:15 2019/1/31
     * @Param [officeCategory, jobPosition, doctorName]
     * @return java.util.Map<java.lang.String,java.util.List<com.mrms.recoversystem.model.Medicalpersonal>>
     **/
    @ResponseBody
    @GetMapping("findDoctor")
    public Map<String, List<Medicalpersonal>> findDoctor(String office, Integer jobPosition, String doctorName) {
        System.out.println(office+" "+jobPosition);
        Integer power = jobPosition;
        Medicalpersonal medicalpersonal = new Medicalpersonal();
        if (doctorName != null) //直接通过搜索医生姓名来寻找医生
            medicalpersonal.setUserName(doctorName);
        else if (office != null && power != null) { //通过科室和职位来寻找医生
            medicalpersonal.setOfficeId(office + "%"); //通过模糊搜索查找该科室的医生
            medicalpersonal.setPower(power);
        }
        List<Medicalpersonal> medicalpersonals = medicalpersonalService.search(1,10,medicalpersonal);
        System.out.println(medicalpersonals);
        if (!medicalpersonals.isEmpty()) {
            Map<String, List<Medicalpersonal>> map = new HashMap<String, List<Medicalpersonal>>();
            map.put("list", medicalpersonals);
            return map;
        } else return null;
    }

    /**
     * @Description: MRMS_Manager_UserList 模块---》根据工作人员编号或姓名查找工作人员的信息
     * @Param: [key, value]
     * @return: java.util.Map<java.lang.String       ,       java.util.List       <       com.mrms.recoversystem.model.Medicalpersonal>>
     * @Author: Luhaojian
     * @Date: 2019/1/22
     */
    @ResponseBody
    @GetMapping("searchUserInfo")
    public Map<String, Object> findUserByInfo(Integer key, String value) {
        Map<String, Object> map = new HashMap<>();
        Medicalpersonal medicalpersonal = new Medicalpersonal();
        if (key == 1)
            medicalpersonal.setUserId(Integer.parseInt(value));
        else
            medicalpersonal.setUserName(value);
        List<Medicalpersonal> users = medicalpersonalService.search(1,10,medicalpersonal);
        if (users == null || users.isEmpty()) {
            map.put("error", "找不到该工作人员信息，请检查输入是否正确");
            return map;
        } else {
            map.put("users", users);
            return map;
        }

    }

    /**
     * @Description: MRMS_Manager_UserList 模块---》跳转到该页面时加载所有的工作人员信息
     * @Param: [key, value]
     * @return: java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author: Luhaojian
     * @Date: 2019/1/22
     */
    @ResponseBody
    @GetMapping("searchAllUsers")
    public Map<String, Object> findAllUsers(@RequestParam(required = false)int pageNum,int pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<Medicalpersonal> users = medicalpersonalService.search(pageNum,pageSize,null);
        PageInfo<Medicalpersonal> userlist = new PageInfo<>(users);
        map.put("users", userlist);
        return map;
    }

    /**
     * @Description:
     * @Param: [userId]
     * @return: com.mrms.recoversystem.model.Medicalpersonal
     * @Author: Luhaojian
     * @Date: 2019/1/22
     */
    @GetMapping("findUserInfo")
    @ResponseBody
    public Map<String,Object> findUserInfo(Integer userId) {
        System.out.println("enter findUserInfo userId = " + userId);
        Map<String,Object> map = new HashMap<>();
        Medicalpersonal result = medicalpersonalService.findSingleUser(userId);
        if (result != null){
            map.put("user",result);
            //查找该医生今天现在一共诊断多少患者
            int restCount =  registerService.getRegisterorderNumber(userId);
            if (restCount != -1)
                map.put("restCount",restCount);
        }

        return map;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 修改密码
     * @Date 16:17 2019/1/31
     * @Param [userId, oldPassWord, newPassWord]
     * @return java.lang.String
     **/
    @PostMapping("updatePassWord")
    @ResponseBody
    public String updatePassWord(Integer userId, String oldPassWord, String newPassWord) {
        System.out.println("userId =" + userId + " oldPassWord = " + oldPassWord + " newPassWord =" + newPassWord);
        Medicalpersonal medicalpersonal = medicalpersonalService.findSingleUser(userId);
        if (medicalpersonal.getPassWord().equals(oldPassWord)) {
            if (oldPassWord.equals(newPassWord))
                return "旧密码和新密码相同，无需更改";
            else {
                medicalpersonal.setPassWord(newPassWord);
                medicalpersonalService.update(medicalpersonal);
                return "修改密码成功";
            }
        } else {
            return "你输入的旧密码不正确，请重新输入";
        }

    }

    /*
     * @Author luhaojian
     * @Description //TODO 更新用户信息
     * @Date 16:18 2019/1/31
     * @Param [medicalpersonal]
     * @return java.lang.Boolean
     **/
    @PostMapping("updateUser")
    @ResponseBody
    public Medicalpersonal updateUserInfo(Medicalpersonal medicalpersonal){
        boolean result = medicalpersonalService.update(medicalpersonal);
        return result == true?medicalpersonal:null;
    }
}
