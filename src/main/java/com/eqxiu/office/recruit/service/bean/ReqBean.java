package com.eqxiu.office.recruit.service.bean;

import com.alibaba.fastjson.JSONObject;
import com.eqxiu.office.recruit.register.RegisterCenter;
import com.eqxiu.office.recruit.service.business.Authentication;

import java.util.HashMap;
import java.util.Map;

public class ReqBean {

    private String apiCode;
    private String token;
    private Map<String, Object> parameter;

    private RespBean verifyResp;

    public static ReqBean parseReqBean(String s){
        ReqBean bean = new ReqBean();
        try {
            JSONObject jsonObject = JSONObject.parseObject(s);
            bean.setApiCode(jsonObject.getString("apiCode"));
            bean.setToken(jsonObject.getString("token"));
            bean.setParameter(jsonObject.getJSONObject("parameter"));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    public static ReqBean verify(ReqBean req) {
        if (req == null) {
            req = new ReqBean();
            req.verifyResp =  RespBean.newError("request parameter parsing error");
        } else if (!RegisterCenter.containsKey(req.getApiCode())){
            req.verifyResp =  RespBean.newError("api_code[ "+ req.getApiCode() + " ] unregistered error");
        } else if (!Authentication.checkToken(req.getToken())) {
            req.verifyResp =  RespBean.newError("token invalidation");
        }
        return req;
    }

    public RespBean errorResp(){
        return verifyResp;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, Object> parameter) {
        this.parameter = parameter;
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("api_code", apiCode);
        jsonObject.put("token", token);
        jsonObject.put("parameter", parameter);
        return jsonObject.toString();
    }

    @Override
    public String toString() {
        return toJsonString();
    }
}
