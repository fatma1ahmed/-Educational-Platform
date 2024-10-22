package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.Enum.EducationalLevel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    @JsonProperty("student_id")
    private long id;
    @JsonProperty("student_name")
    private String name;
    @JsonProperty("student_phone")
    private String phone;
    @JsonProperty("level_id")
    private long levelId;
}
