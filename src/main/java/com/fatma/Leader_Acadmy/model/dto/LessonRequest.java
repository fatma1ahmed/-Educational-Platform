package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.entity.Package;
import com.fatma.Leader_Acadmy.model.entity.Pdf;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import com.fatma.Leader_Acadmy.model.entity.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
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
