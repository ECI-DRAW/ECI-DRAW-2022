package edu.eci.arsw.ecidrawapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.eci.arsw.ecidraw" })
public class EciDrawApplication {

	public static void main(String[] args) {
		SpringApplication.run(EciDrawApplication.class, args);
	}

}
