package com.mrms.recoversystem.controller;

import com.github.pagehelper.PageInfo;
import com.mrms.recoversystem.model.Patient;
import com.mrms.recoversystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: recoversystem
 * @description: 病人信息业务逻辑
 * @author: Luhaojian
 * @create: 2018-12-14 12:04
 **/
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    /*
     * @Author luhaojian
     * @Description //TODO 添加患者信息
     * @Date 9:59 2019/2/26
     * @Param [patient]
     * @return java.lang.Boolean
     **/
    @ResponseBody
    @PostMapping("addPatient")
    public Boolean addPatient(Patient patient) {
        System.out.println("进入 addPatient 方法");
        System.out.println("----------------\n" + patient.toString() + "\n------------------");
        Patient test = new Patient();
        patient.setCarId(patient.getCarId());
        patient.setPhoneNumber(patient.getPhoneNumber());
        boolean res = patientService.addPatient(patient);
        return res;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 通过身份证信息查找患者信息
     * @Date 9:59 2019/2/26
     * @Param [carId]
     * @return com.mrms.recoversystem.model.Patient
     **/
    @GetMapping("searchPatientCarId")
    @ResponseBody
    public Patient searchPatient(String carId) {
        System.out.println("-----enter searchPatientCarId------------");
        Patient patient = new Patient();
        patient.setCarId(carId);
        Patient flag = patientService.searchPatient(patient);
        System.out.println("result=" + flag);
        return flag;
    }

    /*
     * @Author luhaojian
     * @Description //TODO 根据条件查找患者信息
     * @Date 10:00 2019/2/26
     * @Param [key, value]
     * @return com.mrms.recoversystem.model.Patient
     **/
    @GetMapping(value = "searchPatient", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Patient findPatient(Integer key, String value) {
        if (key == null && value == null) {
            return null;
        } else {
            Patient patient = new Patient();
            if (key == 1)
                patient.setPatientId(Integer.parseInt(value));
            else if (key == 2)
                patient.setCarId(value);
            Patient result = patientService.searchPatient(patient);
            System.out.println(result.toString());
            return result;
        }
    }

    /*
     * @Author luhaojian
     * @Description //TODO 根据页数搜索患者信息
     * @Date 10:00 2019/2/26
     * @Param []
     * @return java.util.Map<java.lang.String,java.util.List<com.mrms.recoversystem.model.Patient>>
     **/
    @GetMapping("findAllPatient")
    @ResponseBody
    public Map<String, PageInfo<Patient>> findAllPatient(int pageNum, int pageSize) {
        System.out.println("进入患者列表controller\n----------"+pageNum + " " +pageSize);
        Map<String, PageInfo<Patient>> map = new HashMap<String, PageInfo<Patient>>();
        List<Patient> patients = patientService.findAllPatient(pageNum,pageSize);
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        map.put("patients", pageInfo);

        return map;
    }

    @GetMapping(value = "findAppointedPatient/{pageNum}/{pageSize}")
    @ResponseBody
    public Map<String, PageInfo<Patient>> findAppointedPatient(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize,Patient patient) {
        if (patient != null) {
            System.out.println("-------------patient不为空----------------");
            System.out.println(patient.toString());
        } else System.out.println("-------------patient为空-----------------");

        Map<String, PageInfo<Patient>> map = new HashMap<String, PageInfo<Patient>>();
        List<Patient> patients = patientService.findAppointedPatient(pageNum, pageSize, patient);
        if (patients.isEmpty())
            System.out.println("----------------------找不到patients----------------------------");
        else System.out.println(patients);
        PageInfo<Patient> pages = new PageInfo<>(patients);
        map.put("patients", pages);

        return map;
    }

    /*
     * @Author luhaojian
     * @Description //TODO MRMS_Collector_Register_List.html 页面调用该接口，用于查找某个病人的信息并设置在挂号单上
     * @Date 15:29 2019/3/2
     * @Param [patientId]
     * @return com.mrms.recoversystem.model.Patient
     **/
    @GetMapping("searchAppointedPatient")
    @ResponseBody
    public Patient searchPatient(Integer patientId) {
        System.out.println("进入searchPatient，patientId = " + patientId);
        if (patientId == null)
            return null;
        Patient patient = new Patient();
        patient.setPatientId(patientId);
        Patient result = patientService.searchPatient(patient);
        if (result != null)
            System.out.println(result.toString());
        return result;
    }

    @PostMapping("updatePatient")
    @ResponseBody
    public Patient updatePatient(Patient patient) {
        System.out.println("进入updatePatient，patient为\n" + patient);
        if (patient == null)
            return null;
        Boolean result = patientService.updatePatient(patient);
        if (result == true)
            return patient;
        else return null;
    }

    @PostMapping("deletePatient")
    @ResponseBody
    public Boolean deletePatient(Integer patientId) {
        if (patientId == null)
            return false;
        Boolean result = patientService.deletePatient(patientId);
        return result;
    }
}


