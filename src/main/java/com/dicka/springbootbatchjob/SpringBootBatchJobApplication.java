package com.dicka.springbootbatchjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootBatchJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchJobApplication.class, args);
	}

}
