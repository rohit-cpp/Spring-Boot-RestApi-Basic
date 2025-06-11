package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public Student addStudent(Student student) {

        return this.studentRepository.save(student);
    }

    public Student getStudentById(long studentId) {
        Optional<Student> OptionalValue = this.studentRepository.findById(studentId);

        return OptionalValue.orElse(null);
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        if (existingStudent == null) {
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);

    }
}
