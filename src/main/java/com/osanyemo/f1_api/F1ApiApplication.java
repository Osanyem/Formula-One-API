package com.osanyemo.f1_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class F1ApiApplication {
	private static final Logger logger = LoggerFactory.getLogger(
			F1ApiApplication.class
	);

	public static void main(String[] args) {
		SpringApplication.run(F1ApiApplication.class, args);
	}

}
