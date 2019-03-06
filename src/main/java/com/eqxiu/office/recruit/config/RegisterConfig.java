package com.eqxiu.office.recruit.config;

import com.eqxiu.office.recruit.register.RegisterCenter;
import com.eqxiu.office.recruit.service.business.*;
import org.springframework.stereotype.Component;


@Component
public class RegisterConfig {

    static{
        RegisterCenter.register(Authentication.class);
        RegisterCenter.register(DemandManager.class);
        RegisterCenter.register(FieldManager.class);
        RegisterCenter.register(InterviewFlow.class);
        RegisterCenter.register(ResumeManager.class);
        RegisterCenter.register(UserManager.class);
    }
}
