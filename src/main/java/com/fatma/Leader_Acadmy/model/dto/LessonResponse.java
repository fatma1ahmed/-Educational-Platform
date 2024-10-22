package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    @JsonProperty("lesson_id")
    private long id;
    @JsonProperty("lesson_title")
    private String title;
    @Column(length = 5000)
    @JsonProperty("lesson_ description")
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("lesson_image_path")
    private String imagePath;
    @JsonProperty("teacher_id")
    private long teacherId;
    @JsonProperty("subject_id")
    private long subjectId;
    @JsonProperty("packagee_id")
    private long packageeId;
}
