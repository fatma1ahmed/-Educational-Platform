package com.fatma.Leader_Acadmy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Subject> subjects;
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students;
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> packages;

}
