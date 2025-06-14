package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Enrollement;
import com.example.demo.mapper.EnrollementMapper;
import com.example.demo.repository.EnrollementRepository;

@Service
public class EnrollementService {

    private final EnrollementRepository enrollementRepository;

    @Autowired
    public EnrollementService(EnrollementRepository EnrollementRepository) {
        this.enrollementRepository = EnrollementRepository;
    }

    public Enrollement addEnrollement(Enrollement enrollement) {
        if (enrollement.getEnrollementDate().isAfter(enrollement.getCourse().getStartDate())) {
        }
        if (this.enrollementRepository.countByCourse(enrollement.getCourse())
                + 1 >= enrollement.getCourse().getCapacity()) {
        }
        return this.enrollementRepository.save(enrollement);
    }
}
