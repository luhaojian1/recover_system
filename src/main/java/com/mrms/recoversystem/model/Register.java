package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Register implements Serializable {
    private String registerId;

    private Integer patientId;

    private String diagnosisId;

    private Integer userId;

    private String patientName;

    private Integer visStatus;

    private Integer registrationCategory;

    private Integer diagnosisPrice;

    private Date registerDate;

    private Integer tollCollector;

    //就诊序号
    private Integer diagnosisNo;

    private Patient patient;

    private Medicalpersonal doctor;

    private Medicalpersonal collector;


    private static final long serialVersionUID = 1L;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId == null ? null : diagnosisId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getVisStatus() {
        return visStatus;
    }

    public void setVisStatus(Integer visStatus) {
        this.visStatus = visStatus;
    }

    public Integer getRegistrationCategory() {
        return registrationCategory;
    }

    public void setRegistrationCategory(Integer registrationCategory) {
        this.registrationCategory = registrationCategory;
    }

    public Integer getDiagnosisPrice() {
        return diagnosisPrice;
    }

    public void setDiagnosisPrice(Integer diagnosisPrice) {
        this.diagnosisPrice = diagnosisPrice;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getTollCollector() {
        return tollCollector;
    }

    public void setTollCollector(Integer tollCollector) {
        this.tollCollector = tollCollector;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicalpersonal getDoctor() {
        return doctor;
    }

    public void setDoctor(Medicalpersonal doctor) {
        this.doctor = doctor;
    }

    public Medicalpersonal getCollector() {
        return collector;
    }

    public void setCollector(Medicalpersonal collector) {
        this.collector = collector;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerId='" + registerId + '\'' +
                ", patientId=" + patientId +
                ", diagnosisId='" + diagnosisId + '\'' +
                ", userId=" + userId +
                ", patientName='" + patientName + '\'' +
                ", visStatus=" + visStatus +
                ", registrationCategory=" + registrationCategory +
                ", diagnosisPrice=" + diagnosisPrice +
                ", registerDate=" + registerDate +
                ", tollCollector=" + tollCollector +
                ", diagnosisNo=" + diagnosisNo +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", collector=" + collector +
                '}';
    }

    public Integer getDiagnosisNo() {
        return diagnosisNo;
    }

    public void setDiagnosisNo(Integer diagnosisNo) {
        this.diagnosisNo = diagnosisNo;
    }

}