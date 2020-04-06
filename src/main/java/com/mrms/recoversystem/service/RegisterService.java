package com.mrms.recoversystem.service;

import com.mrms.recoversystem.model.Register;

import java.util.Date;
import java.util.List;

public interface RegisterService {
    public Boolean addRegister(Register register);
    public Register findRegister(Register register);
    public Register findRegisterByRegisterId(String registerId);
    public boolean update(Register register);
    public boolean delete(String registerId);
    public List<Register> findRegisterList(Integer tollCollector, int pageNum , int pageSize);
    public List<Register> findRegistersByDoctorId(Integer doctorId, Integer visStatus);

    public int getRegisterCountWithDoctor(int doctorId, Date startDate, Date endDate);

    public int getRegisterorderNumber(Integer doctorId);
}
