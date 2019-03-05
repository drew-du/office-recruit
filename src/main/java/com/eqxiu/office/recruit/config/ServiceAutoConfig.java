package com.eqxiu.office.recruit.config;

import com.eqxiu.office.recruit.service.IRecruitService;
import com.eqxiu.office.recruit.service.impl.RecruitServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfig {

    @Bean(name = "recruitService")
    public IRecruitService recruitService(){
        return new RecruitServiceImpl();
    }
}
