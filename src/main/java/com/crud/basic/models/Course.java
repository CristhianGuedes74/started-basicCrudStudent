package com.crud.basic.models;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import com.crud.basic.exceptions.subject.SubjectNotFoundException;
import com.crud.basic.models.enums.GenericStates;
import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
@SQLRestriction("state != 'DELETED'")
public class Course extends DataAuditory{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate cycle;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private GenericStates state = GenericStates.ACTIVE;

    public void changeStatus(GenericStates status){
        this.state = status;
    }

    public void changeCourseInfo(String name, Subject subject){
        if(subject == null) throw new SubjectNotFoundException();
        
        this.name = name;
        this.subject = subject;
    }

    public void changeCourseCycle(LocalDate cycle){
        if(cycle.isBefore(LocalDate.now())){
            this.cycle = LocalDate.now();
        }

        this.cycle = cycle;
    }
}
