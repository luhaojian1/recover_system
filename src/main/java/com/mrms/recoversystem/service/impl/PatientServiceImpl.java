package com.mrms.recoversystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.mrms.recoversystem.mapper.PatientMapper;
import com.mrms.recoversystem.model.Patient;
import com.mrms.recoversystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: recoversystem
 * @description: patient接口实现类
 * @author: Luhaojian
 * @create: 2018-12-14 12:06
 **/
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;
    @Override
    public boolean addPatient(Patient patient) {
        int result = patientMapper.insertSelective(patient);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public Patient searchPatient(Patient patient) {
        Patient result = null;
        try {
           result = patientMapper.selectPatient(patient);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean updatePatient(Patient patient) {
        boolean flag = false;
        try {
            int result = patientMapper.update(patient);
            if (result>0)
                flag = true ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag ;

    }

    @Override
    public boolean deletePatient(int patientId) {
        boolean flag = false;
        try {
            int result = patientMapper.delete(patientId);
            if (result>0)
                flag = true ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag ;
    }

    @Override
    public List<Patient> findAppointedPatient(int pageNum, int pageSize, Patient patient) {
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> result = null;
        try{
            result = patientMapper.findAppointedPatient(patient);
        }catch (Exception e){
            System.out.println("找不到对应的patient");
            e.printStackTrace();
        }
            return result;

    }

    @Override
    public List<Patient> findAllPatient(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> result = null;
        try{
            result = patientMapper.findAllPatient();
        }catch (Exception e){
            System.out.println("找不到对应的patient");
            e.printStackTrace();
        }
        return result;
    }

}
