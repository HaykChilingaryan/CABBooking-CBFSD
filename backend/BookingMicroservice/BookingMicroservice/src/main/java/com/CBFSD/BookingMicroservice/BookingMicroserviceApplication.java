package com.CBFSD.BookingMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication( scanBasePackages = "com")
@EntityScan(basePackages = "com.CBFSD.entity")
@EnableJpaRepositories(basePackages =  "com.CBFSD.repository")
@EnableEurekaClient
class BookingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMicroserviceApplication.class, args);
		System.out.println("Booking Microservice is Up");
	}
	
	@Bean
	@LoadBalanced					// di for Rest API to invoke another micro service 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
