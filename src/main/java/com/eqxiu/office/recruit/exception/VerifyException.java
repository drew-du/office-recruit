package com.eqxiu.office.recruit.exception;

import com.eqxiu.office.recruit.service.bean.RespBean;

public class VerifyException extends Exception {

    private RespBean resp;

    public VerifyException(String msg, int type) {
        super(msg);
        resp = new RespBean();
        resp.setMessage(msg);
        resp.setStatusCode(type);
    }

    public RespBean getResp(){
        return resp;
    }

}
