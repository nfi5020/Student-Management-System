package com.example.studentmanagementsystem;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication{

	public static void main(String[] args){
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

/*	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Najrul", "Islam", "najrulislam611@cable.comcast.com");
		studentRepository.save(student1);

		Student student2 = new Student("Syful", "Islam", "sislam@hotmail.com");
		studentRepository.save(student2);

		Student student3 = new Student("Saifan", "Islam", "Saifan_islam@gmail.com");
		studentRepository.save(student3);

	}*/
}
