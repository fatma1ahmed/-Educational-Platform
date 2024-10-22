package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageResponse {
   @JsonProperty("package_id")
    private long id;
    @JsonProperty("Package_title")
    private String title;
    @Column(length = 5000)
    @JsonProperty("Package_description")
    private String description;
    @JsonProperty("teacher_id")
    private long teacherId;
    @JsonProperty("level_id")
    private long levelId;
    @JsonProperty("subject_id")
    private long subjectId;
}
