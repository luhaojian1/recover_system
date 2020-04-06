package com.mrms.recoversystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.mrms.recoversystem.mapper.RegisterMapper;
import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.model.Register;
import com.mrms.recoversystem.service.MedicalpersonalService;
import com.mrms.recoversystem.service.RegisterService;
import com.mrms.recoversystem.util.GenerateNum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: recoversystem
 * @description: 挂号单实现类
 * @author: Luhaojian
 * @create: 2018-12-17 20:21
 **/
@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private MedicalpersonalService mps;
    @Override
    public Boolean addRegister(Register register) {
        if (register == null){
            return false;
        }
        try {
            int userId = register.getUserId();
            Medicalpersonal medicalpersonal = mps.findSingleUser(userId);
            int currentDiagnosisNumber = getRegisterorderNumber(userId);
            int restCount = medicalpersonal.getRegisterSum() - currentDiagnosisNumber;
            if(restCount == 0)  //如果剩余号数为0，拒绝挂号
                return false;
            register.setDiagnosisNo(currentDiagnosisNumber+1);
            register.setRegisterId(createGenerateNum());
            register.setRegisterDate(new Date());
            registerMapper.insertSelective(register);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Register findRegister(Register register) {
        try{
            return registerMapper.searchRegisterWithDoctor(register);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Register findRegisterByRegisterId(String registerId) {
        try {
            return registerMapper.findRegisterById(registerId);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Register register) {
        //System.out.println("更新register="+register.toString());
        try {
            if (register!=null)
            registerMapper.update(register);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(String registerId) {
        try {
            registerMapper.delete(registerId);
             return true;
        }catch (Exception e)
        {

            System.out.println("删除register失败");
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Register> findRegisterList(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Register> result;
        try{
            result = registerMapper.findRegistersTollCollector();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            return result;
    }


    private synchronized String createGenerateNum(){

        try {
            int count = GenerateNum.getCount();

            if ( count == 0  ){
                System.out.println("count = 0 ，需要进行初始化");
                String  result = registerMapper.getMaxRegisterId();
                if (result == null ){
                    System.out.println("register表记录为空，需要进行初始化");
                    count = 1;
                }
                else {
                    int listCount = Integer.parseInt(result);
                    count = listCount + 1;
                }
            }
            String  maxNumber = String.format("%09d",count);
            GenerateNum.setCount(count+1);
            return maxNumber;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Register> findRegistersByDoctorId(Integer doctorId, Integer visStatus) {
        List<Register> result;
        try {
            result = registerMapper.selectRegisterByDoctorId(doctorId,visStatus);
        }catch (Exception e){
            System.out.println("搜索失败");
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 查找指定医生在某个时间段里的时间内的挂号人数
     * @Date 11:12 2019/3/2
     * @Param [doctorId, startDate, endDate]
     * @return int
     **/
    @Override
    public int getRegisterCountWithDoctor(int doctorId, Date startDate, Date endDate) {
        try {
         return registerMapper.getRegisterCountWithDoctor(doctorId,startDate,endDate);
        }catch (Exception e){
            System.out.println("搜索失败");
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author luhaojian
     * @Description //TODO 查找当天指定医生的待诊断患者的人数，然后确定当前患者的挂号序号
     * @Date 11:07 2019/3/2
     * @Param [doctorId]
     * @return int
     **/
    @Override
    public int getRegisterorderNumber(Integer doctorId) {
        try {
            return registerMapper.getRegisterorderNumber(doctorId);
        }catch (Exception e){
            System.out.println("搜索失败");
            e.printStackTrace();
            return -1;
        }
    }


}
