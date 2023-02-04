package com.CBFSD.CabBookingEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class CabBookingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingEurekaServerApplication.class, args);
		System.out.println("Eureka Server is Up");
	}

}
