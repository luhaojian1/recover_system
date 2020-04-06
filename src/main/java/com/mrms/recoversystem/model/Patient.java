package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private Integer patientId;

    private String patientName;

    private Integer age;

    private String nation;

    private String nativePlace;

    private String carId;

    private String homeAdress;

    private String phoneNumber;

    private Date mpBirthday;

    private Boolean sex;

    private String occupation;

    private String workPlace;

    private Double height;

    private Double weight;

    private String bloodType;

    private Boolean famSickHistroy;

    private String sickHistrionicInstruction;

    private Boolean drugAllergy;

    private String drugAllergyIntroduction;

    private static final long serialVersionUID = 1L;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress == null ? null : homeAdress.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getMpBirthday() {
        return mpBirthday;
    }

    public void setMpBirthday(Date mpBirthday) {
        this.mpBirthday = mpBirthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public Boolean getFamSickHistroy() {
        return famSickHistroy;
    }

    public void setFamSickHistroy(Boolean famSickHistroy) {
        this.famSickHistroy = famSickHistroy;
    }

    public String getSickHistrionicInstruction() {
        return sickHistrionicInstruction;
    }

    public void setSickHistrionicInstruction(String sickHistrionicInstruction) {
        this.sickHistrionicInstruction = sickHistrionicInstruction == null ? null : sickHistrionicInstruction.trim();
    }

    public Boolean getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(Boolean drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getDrugAllergyIntroduction() {
        return drugAllergyIntroduction;
    }

    public void setDrugAllergyIntroduction(String drugAllergyIntroduction) {
        this.drugAllergyIntroduction = drugAllergyIntroduction == null ? null : drugAllergyIntroduction.trim();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", carId='" + carId + '\'' +
                ", homeAdress='" + homeAdress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mpBirthday=" + mpBirthday +
                ", sex=" + sex +
                ", occupation='" + occupation + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType + '\'' +
                ", famSickHistroy=" + famSickHistroy +
                ", sickHistrionicInstruction='" + sickHistrionicInstruction + '\'' +
                ", drugAllergy=" + drugAllergy +
                ", drugAllergyIntroduction='" + drugAllergyIntroduction + '\'' +
                '}';
    }
}