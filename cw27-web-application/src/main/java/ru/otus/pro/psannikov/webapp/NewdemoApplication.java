package ru.otus.pro.psannikov.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class NewdemoApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(NewdemoApplication.class, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}