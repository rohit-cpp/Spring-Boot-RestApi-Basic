package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.enums.CourseStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnrollementDto {

    private long studentId;

    private long courseId;

    private LocalDateTime enrollementDate;

    private CourseStatus status = CourseStatus.ACTIVE;
}
