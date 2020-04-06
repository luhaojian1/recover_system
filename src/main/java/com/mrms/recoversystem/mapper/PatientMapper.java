package com.mrms.recoversystem.mapper;

import com.mrms.recoversystem.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMapper {
    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectPatient(Patient patient);

    Patient selectById(Integer record);

    int update(Patient patient);

    int delete(Integer patientId);

    List<Patient> findAllPatient();

    List<Patient> findAppointedPatient(Patient patient);

}