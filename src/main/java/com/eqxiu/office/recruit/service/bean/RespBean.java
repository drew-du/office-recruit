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
    private Map<String, Object> data = new HashMap<>();

    private boolean error = false;

    public static RespBean parseRespBean(String s){
        RespBean bean = new RespBean();
        try {
            JSONObject jsonObject = JSONObject.parseObject(s);
            bean.setMessage(jsonObject.getString("message"));
            bean.setStatusCode(jsonObject.getInteger("statusCode"));
            bean.setData(jsonObject.getJSONObject("data"));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        error = statusCode != STATUS_SUCCESS;
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
    public void putData(String key, Object value){
        data.put(key, value);
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", statusCode);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
        return jsonObject.toString();
    }

    public boolean error(){
        return error;
    }

    public static RespBean newError(String message){
        RespBean bean = new RespBean();
        bean.setStatusCode(RespBean.STATUS_ERROR);
        bean.setMessage(message);
        return bean;
    }

    @Override
    public String toString() {
        return toJsonString();
    }
}
