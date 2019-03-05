package com.eqxiu.office.recruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FileConfig {

    @Bean("filePath")
    public String filePath(Environment env) {
        return env.getProperty("spring.data.filePath");
    }
}
