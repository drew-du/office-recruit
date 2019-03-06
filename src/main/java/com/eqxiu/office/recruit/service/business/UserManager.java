package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.dao.UserRepository;
import com.eqxiu.office.recruit.model.User;
import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {

    private static UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        UserManager.userRepository = userRepository;
    }


    @Register(key = "user_create", args = {"name", "password", "role", "realName"})
    public RespBean create(String name, String password, String role, String realName){
        RespBean resp = new RespBean();
        List<User> suers = userRepository.findAll();
        resp.setStatusCode(RespBean.STATUS_SUCCESS);
        resp.setMessage("success");
        resp.putData("suers", suers);
        return resp;//userId
    }

    @Register(key = "user_query", args = {"userId, role"})
    public RespBean query(String userId, String role){
        return new RespBean();//users
    }
    @Register(key = "user_update", args = {"user"})
    public RespBean update(User user){
        return new RespBean();//userId
    }
    @Register(key = "user_delete", args = {"userId"})
    public RespBean delete(String userId){
        return new RespBean();
    }
    @Register(key = "user_passwd", args = {"userId, oldPassword, newPassword"})
    public RespBean passwd(String userId, String oldPassword, String newPassword){
        return new RespBean();
    }
}
