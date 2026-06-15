package com.crud.basic.models;

import java.time.LocalDate;

import com.crud.basic.exceptions.course.CourseNotFoundException;
import com.crud.basic.exceptions.student.StudentNotFoundException;
import com.crud.basic.models.enums.EnrollmentState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Enrollment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate registeredAt;

    // (Course) N a N (Student)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EnrollmentState state = EnrollmentState.PENDING;

    public void changeCriticInfo(Student student, Course course){
        if(student == null) throw new StudentNotFoundException();
        if(course == null) throw new CourseNotFoundException();

        this.student = student;
        this.course = course;
    }

    public void changeStatus(EnrollmentState status){
        this.state = status;
    }
}
