package com.example.demo.entities;

import java.time.LocalDateTime;

import com.example.demo.enums.CourseStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "enrollement")
public class Enrollement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrollement_date", nullable = false)
    private LocalDateTime enrollementDate;

    @Column(name = "status", nullable = false)
    private CourseStatus status = CourseStatus.ACTIVE;

    // public void setCourse(Course course2) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'setCourse'");
    // }

    // public void setStudent(Student student2) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'setStudent'");
    // }

    // public void setEnrollementDate(LocalDateTime enrollementDate2) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'setEnrollementDate'");
    // }

    // public void setStatus(CourseStatus status2) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    // }

}
