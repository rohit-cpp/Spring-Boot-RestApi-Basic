package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);

    }

    @GetMapping("/student/{sId}")
    public Student getStudentById(@PathVariable(name = "sId") long StudentId) {
        return this.studentService.getStudentById(StudentId);

    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        if (studentId != student.getId()) {

        }
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);

    }
}
