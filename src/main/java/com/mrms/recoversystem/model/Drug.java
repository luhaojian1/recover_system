package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Drug implements Serializable {
    private String drugId;

    private String drugName;

    private String drugProperties;

    private String function;

    private String dosage;

    private String attention;

    private String specifications;

    private Date manufactureDate;

    private Date effectiveDate;

    private String adress;

    private Integer stock;

    private Double unitPrice;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Drug{" +
                "drugId='" + drugId + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugProperties='" + drugProperties + '\'' +
                ", function='" + function + '\'' +
                ", dosage='" + dosage + '\'' +
                ", attention='" + attention + '\'' +
                ", specifications='" + specifications + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", effectiveDate=" + effectiveDate +
                ", adress='" + adress + '\'' +
                ", stock=" + stock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }


    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugProperties() {
        return drugProperties;
    }

    public void setDrugProperties(String drugProperties) {
        this.drugProperties = drugProperties == null ? null : drugProperties.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage == null ? null : dosage.trim();
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention == null ? null : attention.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}