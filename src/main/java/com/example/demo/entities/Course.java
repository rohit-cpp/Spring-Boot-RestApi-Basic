package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)

    private double price;

    @Column(name = "capacity", nullable = false)

    private int capacity;

    @Column(name = "no_of_days", nullable = false)

    private int noOfDays;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @Column(name = "enrolment_end_date", nullable = false)
    private LocalDateTime enrolmentEndDate;

    @JsonIgnore
    public LocalDateTime getEndDate() {
        return this.startDate.plusDays(this.noOfDays);

    }
}
