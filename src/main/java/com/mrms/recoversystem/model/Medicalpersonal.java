package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Medicalpersonal implements Serializable {
    private Integer userId;

    private String officeId;

    private String userName;

    private String passWord;

    private String jobPosition;

    private Integer power;

    private Boolean sex;

    private Integer age;

    private Date mpBirthday;

    private String subject;

    private String doctorIntroduction;

    private Integer registerSum;

    private Office office;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Medicalpersonal{" +
                "userId=" + userId +
                ", officeId='" + officeId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", power=" + power +
                ", sex=" + sex +
                ", age=" + age +
                ", mpBirthday=" + mpBirthday +
                ", subject='" + subject + '\'' +
                ", doctorIntroduction='" + doctorIntroduction + '\'' +
                ", registerSum=" + registerSum +
                ", office=" + office +
                '}';
    }

    public Integer getRegisterSum() {
        return registerSum;
    }

    public void setRegisterSum(Integer registerSum) {
        this.registerSum = registerSum;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition == null ? null : jobPosition.trim();
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getMpBirthday() {
        return mpBirthday;
    }

    public void setMpBirthday(Date mpBirthday) {
        this.mpBirthday = mpBirthday;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction == null ? null : doctorIntroduction.trim();
    }
}