package com.mrms.recoversystem.mapper;

import com.mrms.recoversystem.model.Office;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeMapper {
    int insert(Office record);

    int insertSelective(Office record);

    List<Office> searchOffice(Office office);
    Office findById(String officeId);
    int update(Office office);

    int delete(String officeId);

    List<Office> searchOfficeByHigherOffice(String higherOffice);
}