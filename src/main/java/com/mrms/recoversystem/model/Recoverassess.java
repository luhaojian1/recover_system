package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Recoverassess implements Serializable {
    private Integer reAssessId;

    private Integer patientId;

    private Integer userId;

    private String diagnosisId;

    private Integer assessmentTimes;

    private String recoverSituation;

    private String recoverAssessment;

    private String recoverRemarks;

    private Date assessTime;

    private Integer recoverConditions;

    private Patient patient;

    private Medicalpersonal doctor;

    private static final long serialVersionUID = 1L;

    public Integer getReAssessId() {
        return reAssessId;
    }

    public void setReAssessId(Integer reAssessId) {
        this.reAssessId = reAssessId ;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Recoverassess{" +
                "reAssessId=" + reAssessId +
                ", patientId=" + patientId +
                ", userId=" + userId +
                ", diagnosisId='" + diagnosisId + '\'' +
                ", assessmentTimes=" + assessmentTimes +
                ", recoverSituation='" + recoverSituation + '\'' +
                ", recoverAssessment='" + recoverAssessment + '\'' +
                ", recoverRemarks='" + recoverRemarks + '\'' +
                ", assessTime=" + assessTime +
                ", recoverConditions=" + recoverConditions +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Integer getAssessmentTimes() {
        return assessmentTimes;
    }

    public void setAssessmentTimes(Integer assessmentTimes) {
        this.assessmentTimes = assessmentTimes;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecoverSituation() {
        return recoverSituation;
    }

    public void setRecoverSituation(String recoverSituation) {
        this.recoverSituation = recoverSituation == null ? null : recoverSituation.trim();
    }

    public String getRecoverAssessment() {
        return recoverAssessment;
    }

    public void setRecoverAssessment(String recoverAssessment) {
        this.recoverAssessment = recoverAssessment == null ? null : recoverAssessment.trim();
    }

    public String getRecoverRemarks() {
        return recoverRemarks;
    }

    public void setRecoverRemarks(String recoverRemarks) {
        this.recoverRemarks = recoverRemarks == null ? null : recoverRemarks.trim();
    }

    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
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

    public Integer getRecoverConditions() {
        return recoverConditions;
    }

    public void setRecoverConditions(Integer recoverConditions) {
        this.recoverConditions = recoverConditions;
    }
}