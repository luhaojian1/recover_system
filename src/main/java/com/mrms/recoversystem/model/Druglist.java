package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Druglist implements Serializable {
    private String drugListId;

    private String drugId;

    private String diagnosisId;

    private Integer drugDosage;

    private Date drugListDate;

    private Double drugPrice;

    private Drug drug;

    private Diagnosis diagnosis;

    private static final long serialVersionUID = 1L;

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    @Override
    public String toString() {
        return "Druglist{" +
                "drugListId='" + drugListId + '\'' +
                ", drugId='" + drugId + '\'' +
                ", diagnosisId='" + diagnosisId + '\'' +
                ", drugDosage='" + drugDosage + '\'' +
                ", drugListDate=" + drugListDate +
                ", drugPrice=" + drugPrice +
                ", drug=" + drug +
                ", diagnosis=" + diagnosis +
                '}';
    }

    public Date getDrugListDate() {
        return drugListDate;
    }

    public void setDrugListDate(Date drugListDate) {
        this.drugListDate = drugListDate;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getDrugListId() {
        return drugListId;
    }

    public void setDrugListId(String drugListId) {
        this.drugListId = drugListId;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId == null ? null : diagnosisId.trim();
    }

    public Integer getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(Integer drugDosage) {
        this.drugDosage = drugDosage;
    }

    public Double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Double drugPrice) {
        this.drugPrice = drugPrice;
    }
}