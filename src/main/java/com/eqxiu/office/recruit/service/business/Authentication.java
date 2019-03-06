package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.stereotype.Component;

@Component
public class Authentication {

    public static boolean checkToken(String token) {
        if (token == null || token.isEmpty())
            return false;
        return true;
    }

    @Register(key = "login", args = {"name", "password", "role"})
    public RespBean login(String name, String password, String role){
        return new RespBean();
    }

    @Register(key = "logout", args = "token")
    public RespBean logout(String token){
        return new RespBean();
    }
}
