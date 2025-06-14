package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Course;
import com.example.demo.entities.Enrollement;
import com.example.demo.entities.Student;

@Repository
public interface EnrollementRepository extends JpaRepository<Enrollement, Long> {

    Long countByCourse(Course course);

    List<Enrollement> findByStudent(Student student);

    // List<Enrollement> findByStudentAndStatus(Student student, EnrollementStatus
    // status);
}
