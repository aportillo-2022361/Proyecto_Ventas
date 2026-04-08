package com.ventas.proyect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run API");
	}
}
