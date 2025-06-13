package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

}
