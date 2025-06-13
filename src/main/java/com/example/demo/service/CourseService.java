package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(long courseId) {
        return this.courseRepository.findById(courseId).orElse(null);

    }

}
