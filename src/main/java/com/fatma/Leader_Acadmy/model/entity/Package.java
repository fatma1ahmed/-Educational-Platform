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
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 5000)
    private String description;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "packagee",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lesson> lessons;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Level level;
    @ManyToOne
    private Subject subject;
}
