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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(length = 5000)
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String imagePath;

   @ManyToOne
    private Subject subject;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Package> packages;
   @ManyToOne
    private Level level;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lesson> lessons;



}
