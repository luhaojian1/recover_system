package com.mrms.recoversystem.mapper;

import com.mrms.recoversystem.model.Medicalpersonal;
import com.mrms.recoversystem.model.Register;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegisterMapper {

    int insertSelective(Register record);

    List<Register> findRegistersTollCollector();

    Register searchRegisterWithDoctor(Register register);

    Register findRegisterById(String registerId);

    int update(Register register);

    int delete(String registerId);

    String getMaxRegisterId();

    //用于搜索某个医生所有待诊挂号单的信息
    List<Register> selectRegisterByDoctorId(Integer doctorId, Integer visStatus);

    //查找某个时段内某个医生的挂号数目
    int getRegisterCountWithDoctor(Integer doctorId,Date startDate,Date endDate);

    //查找今天某个医生待诊断的患者数目，用于记录挂号排名
    int getRegisterorderNumber(Integer doctorId);
}
