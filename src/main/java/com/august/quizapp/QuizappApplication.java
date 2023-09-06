package com.august.quizapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);

		System.out.print("\033[H\033[2J"); // Clear the terminal screen
		System.out.println();
		System.out.println();
		System.out.println();
	
		// Get the current time and format it
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
	
		System.out.println("\t\t\t\t\t----------------------QUIZ APP SERVER STARTED: "+formattedTime+"----------------------");
		System.out.println();
		System.out.println();
	}

}
