package com.mrms.recoversystem.model;

import java.io.Serializable;
import java.util.Date;

public class Equipmentlist implements Serializable {
    private String equipmentListId;

    private String diagnosisId;

    private Integer userId;

    private Date equipmentListDate;

    private Integer useTimes;

    private Double usePrice;

    private String rm_id;

    private Diagnosis diagnosis;

    private Medicalpersonal medicalpersonal;

    private Recoverequipment recoverequipment;


    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Equipmentlist{" +
                "equipmentListId='" + equipmentListId + '\'' +
                ", diagnosisId='" + diagnosisId + '\'' +
                ", userId=" + userId +
                ", startDate=" + equipmentListDate +
                ", useTimes=" + useTimes +
                ", usePrice=" + usePrice +
                ", rm_id='" + rm_id + '\'' +
                ", diagnosis=" + diagnosis +
                ", medicalpersonal=" + medicalpersonal +
                ", recoverequipment=" + recoverequipment +
                '}';
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Medicalpersonal getMedicalpersonal() {
        return medicalpersonal;
    }

    public void setMedicalpersonal(Medicalpersonal medicalpersonal) {
        this.medicalpersonal = medicalpersonal;
    }

    public Recoverequipment getRecoverequipment() {
        return recoverequipment;
    }

    public void setRecoverequipment(Recoverequipment recoverequipment) {
        this.recoverequipment = recoverequipment;
    }

    public String getRm_id() {
        return rm_id;
    }

    public void setRm_id(String rm_id) {
        this.rm_id = rm_id;
    }

    public String getEquipmentListId() {
        return equipmentListId;
    }

    public void setEquipmentListId(String equipmentListId) {
        this.equipmentListId = equipmentListId;
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

    public Date getEquipmentListDate() {
        return equipmentListDate;
    }

    public void setEquipmentListDate(Date equipmentListDate) {
        this.equipmentListDate = equipmentListDate;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }

    public Double getUsePrice() {
        return usePrice;
    }

    public void setUsePrice(Double usePrice) {
        this.usePrice = usePrice;
    }
}