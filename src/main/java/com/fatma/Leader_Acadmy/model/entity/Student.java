package com.fatma.Leader_Acadmy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Leader_Acadmy.model.Enum.EducationalLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private EducationalLevel educationalLevel;
    @ManyToMany
    private List<Subject> subjects;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> packages;
    @ManyToOne
    private Level level;
}
