package com.eqxiu.office.recruit.service.impl;

import com.eqxiu.office.recruit.service.IRecruitService;
import com.eqxiu.office.recruit.service.bean.ReqBean;
import com.eqxiu.office.recruit.service.bean.RespBean;

public class RecruitServiceImpl implements IRecruitService {

    @Override
    public RespBean exec(ReqBean req) {
//        if (req.verify().isOk()){
//
//        }
//        return new RespBean();
        RespBean bean = new RespBean();
        bean.setStatusCode(RespBean.STATUS_ERROR);
        bean.setMessage("service initialization failed, unable to connect to database");
        return bean;
    }
}
