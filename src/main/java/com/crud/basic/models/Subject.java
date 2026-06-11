package com.crud.basic.models;

import java.util.List;

import com.crud.basic.models.utils.DataAuditory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Subject extends DataAuditory{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String code;
    
    @Column(nullable = false)
    private Integer credits;
    
    @Column(nullable = false)
    private Integer weeklyHours;

    // @Column(nullable = false)
    // private LocalDateTime createdAt;
    
    // @Column(nullable = false)
    // private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Course> courses;

    @Builder.Default
    private Boolean deleted = false;
}
