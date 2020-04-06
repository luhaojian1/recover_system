package com.mrms.recoversystem.service;

import com.mrms.recoversystem.model.Patient;

import java.util.List;

public interface PatientService {
    public boolean addPatient(Patient patient);
    public Patient searchPatient(Patient patient);
    public boolean updatePatient(Patient patient);
    public boolean deletePatient(int patientId);
    public List<Patient> findAllPatient(int pageNum,int pageSize);
    public List<Patient> findAppointedPatient(int pageNum,int pageSize ,Patient patient);
}
