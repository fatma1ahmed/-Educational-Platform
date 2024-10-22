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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 5000)
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String imagePath;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Video> videos;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pdf>pdfs;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Package packagee;
}
