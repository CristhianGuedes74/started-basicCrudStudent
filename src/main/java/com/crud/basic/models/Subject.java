package com.crud.basic.models;

import org.hibernate.annotations.SQLRestriction;

import com.crud.basic.models.enums.GenericStates;
import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor
@SQLRestriction("state != 'DELETED' AND subjectStatus != 'CLOSED'")
public class Subject extends DataAuditory{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private Integer weeklyHours;

    /* @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Course> courses; */

    @Builder.Default
    private GenericStates state = GenericStates.ACTIVE;


    public void editSubject(String name, Integer credits, Integer weeklyHours){
        this.name = name;
        this.credits = credits;
        this.weeklyHours = weeklyHours;
    }

    public void changeStatus(GenericStates status){
        this.state = status;
    }
}
