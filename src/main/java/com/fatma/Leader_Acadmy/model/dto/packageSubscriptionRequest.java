package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class packageSubscriptionRequest {
    @JsonProperty("student_id")
    private long studentId;
}
