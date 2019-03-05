package com.eqxiu.office.recruit.dao;


import com.eqxiu.office.recruit.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository  extends Repository<User, String> {
    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAll();

    @Query(value = "select * from user where user.token == ?1", nativeQuery = true)
    User findUserByToken(String token);

    @Query(value = "select * from user where user.user_id == ?1", nativeQuery = true)
    User findUserById(String userId);
}
