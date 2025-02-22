package com.caseStudy.bookmyshow;

import com.caseStudy.bookmyshow.Controller.UserController;
import com.caseStudy.bookmyshow.DTOs.SignUpRequestDto;
import com.caseStudy.bookmyshow.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		signUpRequestDto.setEmail("Demsfdo@gmail.com");
		signUpRequestDto.setPassword("fuhgbvdsfihb");

		userController.signup(signUpRequestDto);
	}
}
