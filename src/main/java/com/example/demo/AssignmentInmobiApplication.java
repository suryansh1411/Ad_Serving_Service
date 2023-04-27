package com.example.demo;

import com.example.demo.dao.AdvertiserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentInmobiApplication{
	public static void main(String[] args) {
		SpringApplication.run(AssignmentInmobiApplication.class, args);
		System.out.println("Server is ON!");
	}
}
