package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CourseDto;
import com.example.demo.entities.Course;
import com.example.demo.entities.Mentor;
import com.example.demo.exception.NotFoundException;

import com.example.demo.repository.MentorRepository;

@Component
public class CourseMapper {

    private final MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto) {
        Course c = new Course();
        Mentor m = this.mentorRepository.findById(dto.getMentorId())
                .orElseThrow(() -> new NotFoundException("Cannot find mentor with Id: " + dto.getMentorId()));
        c.setName(dto.getName());

        c.setPrice(dto.getPrice());
        c.setCapacity(dto.getCapacity());
        c.setNoOfDays(dto.getNoOfDays());
        c.setStartDate(dto.getStartDate());
        c.setDescription(dto.getDescription());
        c.setMentor(m);
        c.setEnrolmentEndDate(dto.getEnrolmentEndDate());
        return c;
    }
}
