package com.example.demo.controllers;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EnrollementDto;
import com.example.demo.entities.Enrollement;
import com.example.demo.mapper.EnrollementMapper;
import com.example.demo.service.EnrollementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enrollement")
public class EnrollementController {

    private final EnrollementService enrollementService;
    private final EnrollementMapper enrollementMapper;

    @Autowired
    public EnrollementController(EnrollementService EnrollementService, EnrollementMapper EnrollementMapper) {
        this.enrollementService = EnrollementService;
        this.enrollementMapper = EnrollementMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrollement(@RequestBody EnrollementDto enrollementDto) {
        Enrollement enrollement = this.enrollementMapper.mapToModel(enrollementDto);
        return new ResponseEntity<>(this.enrollementService.addEnrollement(enrollement), HttpStatus.CREATED);
    }
}
