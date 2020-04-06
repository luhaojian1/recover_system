package com.mrms.recoversystem.mapper;

import com.mrms.recoversystem.model.Medicalpersonal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalpersonalMapper {

    int insertSelective(Medicalpersonal record);

    List<Medicalpersonal> searchAllUsers();

    List<Medicalpersonal> search(Medicalpersonal record);

    Medicalpersonal findUserById(Integer record);

    int update(Medicalpersonal record);

    int delete(int userId);
}