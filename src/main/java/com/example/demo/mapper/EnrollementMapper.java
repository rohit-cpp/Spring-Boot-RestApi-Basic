package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entities.Course;
import com.example.demo.entities.Enrollement;
import com.example.demo.entities.Student;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@Component
public class EnrollementMapper {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollementMapper(StudentRepository studentRepository, CourseRepository courseRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollement mapToModel(EnrollementDto dto) {
        Student student = this.studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student with ID: " + dto.getStudentId() + " doesn't exist"));

        Course course = this.courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course with ID:" + dto.getCourseId() + " doesn't exist"));

        Enrollement enrollement = new Enrollement();
        enrollement.setCourse(course);
        enrollement.setStudent(student);
        enrollement.setEnrollementDate(dto.getEnrollementDate());
        enrollement.setStatus(dto.getStatus());
        return enrollement;
    }

}
