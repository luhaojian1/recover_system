package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Paymentlist implements Serializable {
    private String treatSheetId;

    private Integer userId;

    private Integer patientId;

    private String diagnosisId;

    private Double diagnosisSumPrice;

    private Integer payStatus;

    private Date payTime;

    private Boolean treatFinished;

    private Integer treatTimes;

    private Integer totalTreatTimes;

    private String recoverRemarks;

    private Integer tollCollector;

    private Diagnosis diagnosis;

    private Patient patient;


    private Medicalpersonal doctor;

    private Medicalpersonal collector;



    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Paymentlist{" +
                "treatSheetId='" + treatSheetId + '\'' +
                ", userId=" + userId +
                ", patientId=" + patientId +
                ", diagnosisId='" + diagnosisId + '\'' +
                ", diagnosisSumPrice=" + diagnosisSumPrice +
                ", payStatus=" + payStatus +
                ", payTime=" + payTime +
                ", treatFinished=" + treatFinished +
                ", treatTimes=" + treatTimes +
                ", totalTreatTimes=" + totalTreatTimes +
                ", recoverRemarks='" + recoverRemarks + '\'' +
                ", tollCollector=" + tollCollector +
                ", diagnosis=" + diagnosis +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", collector=" + collector +
                '}';
    }

    public Integer getTotalTreatTimes() {
        return totalTreatTimes;
    }

    public void setTotalTreatTimes(Integer totalTreatTimes) {
        this.totalTreatTimes = totalTreatTimes;
    }

    public Boolean getTreatFinished() {
        return treatFinished;
    }

    public void setTreatFinished(Boolean treatFinished) {
        this.treatFinished = treatFinished;
    }

    public Integer getTreatTimes() {
        return treatTimes;
    }

    public void setTreatTimes(Integer treatTimes) {
        this.treatTimes = treatTimes;
    }


    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getTollCollector() {
        return tollCollector;
    }

    public void setTollCollector(Integer tollCollector) {
        this.tollCollector = tollCollector;
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

    public String getTreatSheetId() {
        return treatSheetId;
    }

    public void setTreatSheetId(String treatSheetId) {
        this.treatSheetId = treatSheetId == null ? null : treatSheetId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Double getDiagnosisSumPrice() {
        return diagnosisSumPrice;
    }

    public void setDiagnosisSumPrice(Double diagnosisSumPrice) {
        this.diagnosisSumPrice = diagnosisSumPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getRecoverRemarks() {
        return recoverRemarks;
    }

    public void setRecoverRemarks(String recoverRemarks) {
        this.recoverRemarks = recoverRemarks == null ? null : recoverRemarks.trim();
    }

}
