package com.mrms.recoversystem.service;

import com.mrms.recoversystem.model.Medicalpersonal;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MedicalpersonalService {
    boolean add(Medicalpersonal medicalpersonal);
    List<Medicalpersonal> search(int pageNum, int pageSize, Medicalpersonal medicalpersonal);
    Medicalpersonal findSingleUser(Integer userId);
    boolean update(Medicalpersonal medicalpersonal);
    boolean delete(Integer userId);
    Medicalpersonal validateUserInfo(Integer userId, String passWord, HttpSession session);
}
