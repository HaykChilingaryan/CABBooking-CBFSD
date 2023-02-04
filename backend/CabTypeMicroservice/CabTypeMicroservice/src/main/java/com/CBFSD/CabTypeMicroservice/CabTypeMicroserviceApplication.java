package com.CBFSD.CabTypeMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication( scanBasePackages = "com")
@EntityScan(basePackages = "com.CBFSD.entity")
@EnableJpaRepositories(basePackages =  "com.CBFSD.repository")
@EnableEurekaClient
public class CabTypeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabTypeMicroserviceApplication.class, args);
		System.out.println("Cab Type microservice up");
	}

}
