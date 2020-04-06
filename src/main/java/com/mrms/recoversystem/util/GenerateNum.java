package com.mrms.recoversystem.util;

/**
 * @program: recoversystem
 * @description: 订单号生成类
 * @author: Luhaojian
 * @create: 2018-12-12 18:53
 **/


/**
 * 生成订单号类
 */

public class GenerateNum {
    // 创建一个空实例对象，类需要用的时候才赋值
    private static GenerateNum g = null;
    // 挂号单全局自增数
    private static Integer count = 0;
    //康复器材流水号自增数
    private static Integer equipmentListCount = 0;
    //药单列表自增数
    private static Integer drugListCount = 0;
    //诊断记录自增函数
    private static Integer diagnosisCount = 0;
    //收费单自增数
    private static Integer paymentCount = 0;
    //康复评定自增数
    private static Integer recoverAssessCount = 0;

    // 使用单例模式，不允许直接创建实例
    private GenerateNum() {
    }

    // 单例模式--懒汉模式
    public static synchronized GenerateNum getInstance() {
        if (g == null) {
            g = new GenerateNum();
        }
        return g;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        GenerateNum.count = count;
    }

    public static void setCount(Integer count) {
        GenerateNum.count = count;
    }

    public static Integer getEquipmentListCount() {
        return equipmentListCount;
    }

    public static void setEquipmentListCount(Integer equipmentListCount) {
        GenerateNum.equipmentListCount = equipmentListCount;
    }

    public static Integer getDrugListCount() {
        return drugListCount;
    }

    public static void setDrugListCount(Integer drugListCount) {
        GenerateNum.drugListCount = drugListCount;
    }

    public static Integer getDiagnosisCount() {
        return diagnosisCount;
    }

    public static void setDiagnosisCount(Integer diagnosisCount) {
        GenerateNum.diagnosisCount = diagnosisCount;
    }

    public static Integer getPaymentCount() {
        return paymentCount;
    }

    public static void setPaymentCount(Integer paymentCount) {
        GenerateNum.paymentCount = paymentCount;
    }

    public static Integer getRecoverAssessCount() {
        return recoverAssessCount;
    }

    public static void setRecoverAssessCount(Integer recoverAssessCount) {
        GenerateNum.recoverAssessCount = recoverAssessCount;
    }
}
