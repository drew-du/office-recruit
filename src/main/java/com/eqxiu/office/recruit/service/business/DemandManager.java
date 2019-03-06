package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.model.Demand;
import com.eqxiu.office.recruit.model.Field;
import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.Condition;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.stereotype.Component;

@Component
public class DemandManager {

    @Register(key = "demand_create", args = {"fields"})
    public RespBean create(Field[] fields){
        return new RespBean();//demandId
    }

    @Register(key = "demand_query", args = {"conditions", "position", "pageSize", "offset"})
    public RespBean query(Condition[] conditions, String position, int pageSize, int offset){
        return new RespBean();
    }

    @Register(key = "demand_update", args = {"demand", "fields"})
    public RespBean update(Demand demand, Field[] fields){
        return new RespBean();
    }

    @Register(key = "demand_delete", args = {"demandId"})
    public RespBean delete(String demandId){
        return new RespBean();
    }

    @Register(key = "demand_apply", args = {"demandId"})
    public RespBean apply(String demandId){
        return new RespBean();
    }

    @Register(key = "demand_approval", args = {"demandId", "opinion"})
    public RespBean approval(String demandId, int opinion){
        return new RespBean();
    }
}
