package com.mrms.recoversystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.mrms.recoversystem.mapper.MedicalpersonalMapper;
import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.service.MedicalpersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: recoversystem
 * @description: Medicalpersonal实现类
 * @author: Luhaojian
 * @create: 2018-12-18 16:21
 **/
@Service
public class MedicalpersonalServiceImpl implements MedicalpersonalService {

    private static final Logger log = LoggerFactory.getLogger(MedicalpersonalServiceImpl.class);
    @Autowired
    private MedicalpersonalMapper medicalpersonalMapper;

    @Override
    public boolean add(Medicalpersonal medicalpersonal) {

        try {
            String jobPosition = medicalpersonal.getJobPosition();
            if (jobPosition.equals("管理员"))
                medicalpersonal.setPower(0);
            else if (jobPosition.equals("收费员"))
                medicalpersonal.setPower(5);
            else if (jobPosition.equals("医生"))
                medicalpersonal.setPower(3);
            else if (jobPosition.equals("副主任"))
                medicalpersonal.setPower(2);
            else if (jobPosition.equals("主任"))
                medicalpersonal.setPower(1);
            else if (jobPosition.equals("治疗师"))
                medicalpersonal.setPower(4);
            medicalpersonalMapper.insertSelective(medicalpersonal);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Medicalpersonal> search(int pageNum, int pageSize, Medicalpersonal medicalpersonal) {
        PageHelper.startPage(pageNum,pageSize);
        List<Medicalpersonal> result = null;
        try {
            if (medicalpersonal != null)
                result = medicalpersonalMapper.search(medicalpersonal);
            else
                result = medicalpersonalMapper.searchAllUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Medicalpersonal findSingleUser(Integer userId) {
        Medicalpersonal result = null;
        try {
            result = medicalpersonalMapper.findUserById(userId);
        } catch (Exception e) {
            log.warn("userId: " + userId + " can not not found. " + e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Medicalpersonal medicalpersonal) {

        try {
            medicalpersonalMapper.update(medicalpersonal);
            return true;
        } catch (Exception e) {
            log.warn("userId: " + medicalpersonal.getUserId() + " update failed." + e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer userId) {
        try {
            medicalpersonalMapper.delete(userId);
            return true;
        } catch (Exception e) {
            log.warn("userId: " + userId + " delete failed. " + e);
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Medicalpersonal validateUserInfo(Integer userId, String passWord, HttpSession session) {
        try {
            Medicalpersonal result = medicalpersonalMapper.findUserById(userId);
            if (result == null){
                return null;
            }
            if(result.getPassWord().equals(passWord)) {
                session.setAttribute("user",result);
                return result;
            }
            return null;
        } catch (Exception e) {
            log.warn("userId: " + userId + " can not not found. " + e);
            e.printStackTrace();
            return null;
        }
    }
}
