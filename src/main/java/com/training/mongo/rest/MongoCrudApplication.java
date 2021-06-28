package com.training.mongo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.training.mongo.rest.controlleradvices.GlobalExceptionHandler;

@SpringBootApplication
//@Import(GlobalExceptionHandler.class)

public class MongoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoCrudApplication.class, args);
	}

}
