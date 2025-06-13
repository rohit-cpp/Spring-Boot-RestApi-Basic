package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDto;
import com.example.demo.entities.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;

    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto) {
        Course course = this.courseMapper.mapToModel(courseDto);
        return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
    }

}
