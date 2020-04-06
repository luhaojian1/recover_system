package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Diagnosis implements Serializable {
    private String diagnosisId;

    private String registerId;

    private Integer doctorId;

    private Integer patientId;

    private String chiefComplaint;

    private String recoverPlan;

    private String sickClassification;

    private Integer sickLevel;

    private String diagnosisResult;

    private Date diagnosisDate;

    private Register register;

    private Medicalpersonal doctor;

    private Patient patient;

    private List<Druglist> druglists;

    private List<Equipmentlist> equipmentlists;

    private static final long serialVersionUID = 1L;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Medicalpersonal getDoctor() {
        return doctor;
    }

    public void setDoctor(Medicalpersonal doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public List<Druglist> getDruglists() {
        return druglists;
    }

    public void setDruglists(List<Druglist> druglists) {
        this.druglists = druglists;
    }

    public List<Equipmentlist> getEquipmentlists() {
        return equipmentlists;
    }

    public void setEquipmentlists(List<Equipmentlist> equipmentlists) {
        this.equipmentlists = equipmentlists;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId == null ? null : diagnosisId.trim();
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }


    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint == null ? null : chiefComplaint.trim();
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId='" + diagnosisId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", chiefComplaint='" + chiefComplaint + '\'' +
                ", recoverPlan='" + recoverPlan + '\'' +
                ", sickClassification='" + sickClassification + '\'' +
                ", sickLevel=" + sickLevel +
                ", diagnosisResult='" + diagnosisResult + '\'' +
                ", diagnosisDate=" + diagnosisDate +
                ", register=" + register +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", druglists=" + druglists +
                ", equipmentlists=" + equipmentlists +
                '}';
    }

    public String getRecoverPlan() {
        return recoverPlan;
    }

    public void setRecoverPlan(String recoverPlan) {
        this.recoverPlan = recoverPlan;
    }

    public String getSickClassification() {
        return sickClassification;
    }

    public void setSickClassification(String sickClassification) {
        this.sickClassification = sickClassification == null ? null : sickClassification.trim();
    }

    public Integer getSickLevel() {
        return sickLevel;
    }

    public void setSickLevel(Integer sickLevel) {
        this.sickLevel = sickLevel;
    }

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public void setDiagnosisResult(String diagnosisResult) {
        this.diagnosisResult = diagnosisResult == null ? null : diagnosisResult.trim();
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }
}