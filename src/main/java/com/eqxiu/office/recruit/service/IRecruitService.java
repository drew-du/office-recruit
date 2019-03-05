package com.eqxiu.office.recruit.service;

import com.eqxiu.office.recruit.service.bean.ReqBean;
import com.eqxiu.office.recruit.service.bean.RespBean;

public interface IRecruitService {
    RespBean exec(ReqBean req);
}
