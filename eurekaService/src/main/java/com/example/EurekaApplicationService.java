package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//项目启动类
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationService.class, args);
	}

}
