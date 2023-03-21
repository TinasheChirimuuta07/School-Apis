package com.classregister.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {


	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	/*@Bean
CommandLineRunner command (StudentRepository studentRepository){  // this runs automatically at the end of our application
		return  args -> {
			Student students = new Student();
			studentRepository.save(students);
		};
}*/
}
