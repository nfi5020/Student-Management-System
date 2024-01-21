package com.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, message = "The length is larger than 15")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 15, message = "The length is larger than 15")
    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Please provide a valid email")
    @Size(max = 30, message = "The length is larger than 30")
    @Column (name = "email", nullable = false)
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
