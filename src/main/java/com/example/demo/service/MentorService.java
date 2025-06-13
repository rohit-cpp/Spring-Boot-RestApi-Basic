package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mentor;
import com.example.demo.repository.MentorRepository;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {

        return this.mentorRepository.save(mentor);
    }
}
