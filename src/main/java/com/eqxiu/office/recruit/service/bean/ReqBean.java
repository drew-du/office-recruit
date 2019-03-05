package com.eqxiu.office.recruit.service.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ReqBean {

    private String apiCode;
    private String token;
    private Map<String, Object> parameter;

    private boolean ok = false;

    public static ReqBean parseReqBean(String s){
        return null;
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
        Map<String, Object> map = new HashMap<>();
        map.put("api_code", apiCode);
        map.put("token", token);
        map.put("parameter", parameter);
        return new JSONObject(map).toString();
    }

    public ReqBean verify(String... params){
        if (apiCode != null && !apiCode.isEmpty())
            ok = true;
        return this;
    }

    public boolean isOk(){
        return ok;
    }
}
