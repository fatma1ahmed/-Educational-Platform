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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lesson> lessons;
    @ManyToOne
    private Level level;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> packages;


}
