package com.example.New.Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/test")
@SpringBootApplication
public class NewGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewGameApplication.class, args);
	}

}
