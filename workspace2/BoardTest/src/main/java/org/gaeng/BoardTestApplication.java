package org.gaeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.gaeng")
public class BoardTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardTestApplication.class, args);
	}

}
