package com.example.HospitalV2doctorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalV2DoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalV2DoctorServiceApplication.class, args);
	}

}
