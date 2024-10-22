package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.entity.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageRequest {
    @JsonProperty("Package_title")
    private String title;
    @Column(length = 5000)
    @JsonProperty("Package_description")
    private String description;
    @JsonProperty("teacher_id")
    private long teacherId;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("level_id")
    private long levelId;
    @JsonProperty("subject_id")
    private long subjectId;
}
