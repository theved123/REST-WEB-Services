package com.readymade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.addition.service.Addition;

@SpringBootApplication
public class ConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeApplication.class, args);
		
		Addition add=new Addition();
		add.sum(12, 20);
	}

}
