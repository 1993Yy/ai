package com.yy;

import com.yy.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiApplication.class, args);
	}

	@Autowired
	Account account;

	@GetMapping("/")
	public String test(){
		return "hello";
	}
}
