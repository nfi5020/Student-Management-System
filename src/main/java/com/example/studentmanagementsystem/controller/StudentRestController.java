package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.exception.NoStudentFoundException;
import com.example.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentRestController {
    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> listStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);

        if (student == null){
            throw new NoStudentFoundException("id: " + id);
        }
        return student;
    }

    @PostMapping("/students")
    public ResponseEntity<Object> addNewStudent(@Valid @RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        URI link = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(link).build();
    }

    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@Valid @PathVariable Long id){
        Student student = studentService.deleteStudent(id);

        if (student == null){
            throw new NoStudentFoundException("There are no student with the given id: " + id);        }

        return student;
    }
}
