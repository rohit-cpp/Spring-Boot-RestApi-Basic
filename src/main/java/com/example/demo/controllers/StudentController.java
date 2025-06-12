package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

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
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
        try {
            return ResponseEntity.ok(this.studentService.addStudent(student));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));

        }

    }

    @GetMapping("/student/{sId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "sId") long studentId) {

        try {
            Student student = this.studentService.getStudentById(studentId);
            // return ResponseEntity.ok(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }

    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<?>

            updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        try {
            if (studentId != student.getId()) {
                return ResponseEntity.badRequest().body(Map.of("message", "ID in the path and the body are not same"));

            }
            Student updatedStudent = this.studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);

        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable long studentId) {

        try {
            this.studentService.deleteStudentById(studentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {

            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }

    }
}
