package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {
    @JsonProperty("teacher_id")
    private long id;
    @JsonProperty("teacher_name")
    private String name;
    @Column(length = 5000)
    @JsonProperty("teacher_description")
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("teacher_image_path")
    private String imagePath;
    @JsonProperty("level_id")
    private long levelId;
    @JsonProperty("subject_id")
    private long subjectId;
}
