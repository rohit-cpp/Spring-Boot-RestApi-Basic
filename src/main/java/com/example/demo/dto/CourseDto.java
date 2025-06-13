package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entities.Mentor;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {

    private String name;

    @Min(0)
    private double price;

    @Min(10)
    private int capacity;

    @Min(3)
    @Max(60)
    private int noOfDays;

    private LocalDateTime startDate;

    private String description;

    private long mentorId;

    private LocalDateTime enrolmentEndDate;

}
