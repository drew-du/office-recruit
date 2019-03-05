package com.eqxiu.office.recruit.dao;


import com.eqxiu.office.recruit.model.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ResumeDataRepository extends Repository<Field, Integer> {
    @Query(value = "select * from field", nativeQuery = true)
    List<Field> findAll();

    @Query(value = "select * from field where field.code == ?1", nativeQuery = true)
    Field findFieldByCode(String code);

    @Query(value = "select * from field where field.id == ?1", nativeQuery = true)
    Field findFieldById(String id);
}
