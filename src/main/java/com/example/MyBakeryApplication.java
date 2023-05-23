package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyBakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBakeryApplication.class, args);
		System.out.println("================================= Run Finish =================================");
	}

}
