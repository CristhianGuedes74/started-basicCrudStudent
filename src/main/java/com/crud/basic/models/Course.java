package com.crud.basic.models;

import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Course extends DataAuditory{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String name;
    
    // @Column(nullable = false)
    // private LocalDateTime createdAt;
    
    // @Column(nullable = false)
    // private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Builder.Default
    private Boolean deleted = false;
}
