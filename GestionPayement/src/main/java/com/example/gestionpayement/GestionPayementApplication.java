package com.example.gestionpayement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionPayementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionPayementApplication.class, args);
    }

}
