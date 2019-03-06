package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.model.Field;
import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.stereotype.Component;

@Component
public class FieldManager {

    @Register(key = "field_create", args = {"fields"})
    public RespBean create(Field[] fields){
        return new RespBean();//codes
    }

    @Register(key = "field_query", args = {"position", "pageSize", "offset"})
    public RespBean query(String position, int pageSize, int offset){
        return new RespBean();
    }

    @Register(key = "field_update", args = {"fields"})
    public RespBean update(Field[] fields){
        return new RespBean();//codes
    }

    @Register(key = "field_delete", args = {"fields"})
    public RespBean delete(Field[] fields){
        return new RespBean();//codes
    }

    @Register(key = "field_enable", args = {"fields"})
    public RespBean enable(Field[] fields){
        return new RespBean();//codes
    }
}
