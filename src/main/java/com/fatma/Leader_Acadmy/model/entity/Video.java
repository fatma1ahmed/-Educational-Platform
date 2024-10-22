package com.fatma.Leader_Acadmy.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 5000)
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String url;
    @ManyToOne
    private Lesson lesson;
}
