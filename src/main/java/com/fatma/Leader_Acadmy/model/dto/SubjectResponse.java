package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {
    @JsonProperty("subject_id")
    private long id;
    @JsonProperty("subject_name")
    private String name;
    @JsonProperty("level_id")
    private long levelId;
}
