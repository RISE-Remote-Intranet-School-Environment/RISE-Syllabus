package com.RISE.sylla;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyllaApplication {

	private static final Logger log = LoggerFactory.getLogger(SyllaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SyllaApplication.class, args);
	}
}
