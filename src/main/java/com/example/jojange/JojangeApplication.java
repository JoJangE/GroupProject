package com.example.jojange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JojangeApplication {
	public static void main(String[] args) {
		SpringApplication.run(JojangeApplication.class, args);
	}
}
