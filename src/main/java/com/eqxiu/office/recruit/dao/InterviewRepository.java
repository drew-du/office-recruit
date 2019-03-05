package com.eqxiu.office.recruit.dao;


import com.eqxiu.office.recruit.model.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface InterviewRepository extends Repository<Field, Integer> {
    @Query(value = "select * from interview", nativeQuery = true)
    List<Field> findAll();

    @Query(value = "select * from field where field.code == ?1", nativeQuery = true)
    Field findFieldByCode(String code);

    @Query(value = "select * from field where field.id == ?1", nativeQuery = true)
    Field findFieldById(String id);
//
//    @Query(value = "delete from bdsp_storm_manage where id=?1 ", nativeQuery = true)
//    @Modifying
//    public void deleteStormManageById(int id);
//
//    //根据id获取数据源
//    @Query(value = "select * from bdsp_storm_manage where id=?1 ", nativeQuery = true)
//    public StormManage findStormManageById(int id);
//
//    //修改Storm的state的状态
//    @Query(value = "update bdsp_storm_manage sm set sm.state=?1 where sm.id=?2 ", nativeQuery = true)
//    @Modifying
//    public void updateStormManageState(int state,int id);
//
//    //根据id获取数据源
//    @Query(value = "select * from bdsp_storm_manage where enter_topic=?1 ", nativeQuery = true)
//    public List<StormManage> findStormManageByEnterTopic(int enterTopic);
}
