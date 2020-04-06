package com.mrms.recoversystem.model;

import java.io.Serializable;

public class Office implements Serializable {
    private String officeId;

    private Integer officeCategory;

    private String officeName;

    private String srPosition;

    private String higherOffice;

    @Override
    public String toString() {
        return "Office{" +
                "officeId='" + officeId + '\'' +
                ", officeCategory=" + officeCategory +
                ", officeName='" + officeName + '\'' +
                ", srPosition='" + srPosition + '\'' +
                ", higherOffice'=" + higherOffice +
                '}';
    }

    private static final long serialVersionUID = 1L;

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    public Integer getOfficeCategory() {
        return officeCategory;
    }

    public void setOfficeCategory(Integer officeCategory) {
        this.officeCategory = officeCategory;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName == null ? null : officeName.trim();
    }

    public String getSrPosition() {
        return srPosition;
    }

    public void setSrPosition(String srPosition) {
        this.srPosition = srPosition == null ? null : srPosition.trim();
    }

    public String getHigherOffice() {
        return higherOffice;
    }

    public void setHigherOffice(String higherOffice) {
        this.higherOffice = higherOffice;
    }
}