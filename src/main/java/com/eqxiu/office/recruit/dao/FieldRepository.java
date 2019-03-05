package com.eqxiu.office.recruit.dao;


import com.eqxiu.office.recruit.model.Field;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FieldRepository extends Repository<Field, Integer> {

    @Query(value = "select * from field", nativeQuery = true)
    List<Field> findAll();

    Field save(Field field);

    @Modifying
    @Query("update field set field.enable = ?1 where field.id=?2")
    int updateNameById(int enable, int id);
}
