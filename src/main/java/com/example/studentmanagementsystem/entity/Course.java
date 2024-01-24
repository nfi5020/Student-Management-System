package com.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 3, max = 3)
    @NotNull
    @Column(name = "course_credit", nullable = false)
    private int courseCredit;

    @Size(min = 3)
    @NotNull(message = "course name cannot be null")
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Size(min = 4)
    @Column(name = "course_description", nullable = false)
    private String courseDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Course() {
    }

    public Course(long id, int courseCredit, String courseName, String courseDescription) {
        this.id = id;
        this.courseCredit = courseCredit;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCredit=" + courseCredit +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", student=" + student +
                '}';
    }
}