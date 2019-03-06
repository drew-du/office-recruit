package com.eqxiu.office.recruit.service.impl;

import com.eqxiu.office.recruit.register.RegisterCenter;
import com.eqxiu.office.recruit.service.IRecruitService;
import com.eqxiu.office.recruit.service.bean.ReqBean;
import com.eqxiu.office.recruit.service.bean.RespBean;
import com.eqxiu.office.recruit.service.business.Authentication;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl implements IRecruitService {

    @Override
    public RespBean exec(ReqBean req) {
        if ((req = ReqBean.verify(req)).errorResp() != null){
            return req.errorResp();
        }
        try {
            return RegisterCenter.getValue(req.getApiCode(), req.getParameter());
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.newError("unknown error");
        }
    }
}
