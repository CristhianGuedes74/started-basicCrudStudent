package com.crud.basic.models;

import org.hibernate.annotations.SQLRestriction;

import com.crud.basic.models.enums.GenericStates;
import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Builder.Default
    private GenericStates state = GenericStates.ACTIVE;

    public void changeStatus(GenericStates status){
        this.state = status;
    }

    public void changeCourseName(String name){
        this.name = name;
    }
}
