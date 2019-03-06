package com.eqxiu.office.recruit;

import com.eqxiu.office.recruit.config.RegisterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EqxiuOfficeRecruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EqxiuOfficeRecruitApplication.class, args);
		RegisterConfig config = new RegisterConfig();
	}

}
