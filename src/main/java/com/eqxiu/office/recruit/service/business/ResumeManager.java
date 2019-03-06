package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.model.Field;
import com.eqxiu.office.recruit.model.Resume;
import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.Condition;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.stereotype.Component;

@Component
public class ResumeManager {
    @Register(key = "resume_create", args = {"filePath", "fields"})
    public RespBean create(String filePath, Field[] fields){
        return new RespBean();//resumeId
    }

    @Register(key = "resume_query", args = {"conditions", "position", "pageSize", "offset"})
    public RespBean query(Condition[] conditions, String position, int pageSize, int offset){
        return new RespBean();
    }

    @Register(key = "resume_update", args = {"resume", "fields"})
    public RespBean update(Resume resume, Field[] fields){
        return new RespBean();
    }

    @Register(key = "resume_delete", args = {"resumeId"})
    public RespBean delete(String resumeId){
        return new RespBean();
    }
}
