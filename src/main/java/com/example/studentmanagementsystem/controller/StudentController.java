package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Course;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.studentmanagementsystem.exception.*;

import java.util.List;


@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){

        // create student object ot hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@Valid @PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // Get the existing student if there is any
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // Save the updated student
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/courses")
    public String getAllCourse(@PathVariable Long id, Model model){
        Student student = studentService.getStudentById(id);

        if (student == null){
            throw new NoStudentFoundException("id: " + id);
        }

        model.addAttribute("courses", student.getCourse());

        return "courses";
    }
}

    //insert into course values (1, 3, 'SRA 100', 'In this course student will learn about the fundementals of Cyber Security', 1);
    //insert into course values (2, 3, 'SRA 200', 'In this course student will learn advance topics of Cyber Security', 1);
    //insert into course values (3, 4, 'IST 440', 'Student will work on a large application from start to finish', 1);