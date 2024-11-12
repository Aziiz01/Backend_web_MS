package com.esprit.commentaireService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.EnableFeignClients;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CommentaireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentaireServiceApplication.class, args);
	}

}
