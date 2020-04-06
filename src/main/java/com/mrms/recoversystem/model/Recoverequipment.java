package com.mrms.recoversystem.model;

import java.io.Serializable;

public class Recoverequipment implements Serializable {
    private String rm_id;

    private String officeId;

    private String rm_name;

    private Integer rm_number;

    private String rm_specifications;

    private String rm_classification;

    private String rm_function;

    private Double hourUnitPrice;

    private Office office;

    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "Recoverequipment{" +
                "rm_id='" + rm_id + '\'' +
                ", officeId='" + officeId + '\'' +
                ", rm_name='" + rm_name + '\'' +
                ", rm_number=" + rm_number +
                ", rm_specifications='" + rm_specifications + '\'' +
                ", rm_classification='" + rm_classification + '\'' +
                ", rm_function='" + rm_function + '\'' +
                ", hourUnitPrice=" + hourUnitPrice +
                ", office=" + office +
                '}';
    }

    public String getRm_id() {
        return rm_id;
    }

    public void setRm_id(String rm_id) {
        this.rm_id = rm_id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getRm_name() {
        return rm_name;
    }

    public void setRm_name(String rm_name) {
        this.rm_name = rm_name;
    }

    public Integer getRm_number() {
        return rm_number;
    }

    public void setRm_number(Integer rm_number) {
        this.rm_number = rm_number;
    }

    public String getRm_specifications() {
        return rm_specifications;
    }

    public void setRm_specifications(String rm_specifications) {
        this.rm_specifications = rm_specifications;
    }

    public String getRm_classification() {
        return rm_classification;
    }

    public void setRm_classification(String rm_classification) {
        this.rm_classification = rm_classification;
    }

    public String getRm_function() {
        return rm_function;
    }

    public void setRm_function(String rm_function) {
        this.rm_function = rm_function;
    }

    public Double getHourUnitPrice() {
        return hourUnitPrice;
    }

    public void setHourUnitPrice(Double hourUnitPrice) {
        this.hourUnitPrice = hourUnitPrice;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}