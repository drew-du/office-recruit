package com.eqxiu.office.recruit.service.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RespBean {

    public static final int STATUS_SUCCESS = 100;
    public static final int STATUS_FAILURE = 110;
    public static final int STATUS_ERROR = 101;

    private int statusCode;
    private String message;
    private Map<String, Object> data;

    public static RespBean parseRespBean(String s){
        return null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String toJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("status_code", statusCode);
        map.put("message", message);
        map.put("data", data);
        return new JSONObject(map).toString();
    }
}
