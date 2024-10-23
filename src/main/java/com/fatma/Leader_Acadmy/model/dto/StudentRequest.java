package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.Enum.EducationalLevel;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @JsonProperty("student_name")
    @NotNull(message = "please,enter your name")
    private String name;
    @JsonProperty("student_password")
    @NotNull(message = "please,enter your password")
    @Column(unique = true)
    @Size(min = 8,max = 18,message = "enter your password between 8 and 18 character")
    private String password;
    @JsonProperty("student_phone")
    @NotNull(message = "please,enter your phone")
    @Column(unique = true)
    @Pattern(regexp = "\\d{4}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ####-###-#### format.")
    private String phone;
    @JsonProperty("student_educational_level")
    @Enumerated(EnumType.STRING)
    private EducationalLevel educationalLevel;
    @JsonProperty("level_id")
    private long levelId;

}
