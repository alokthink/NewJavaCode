package com.photoDiscoveryUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoDiscoveryUsersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoDiscoveryUsersApiApplication.class, args);
	}

}
