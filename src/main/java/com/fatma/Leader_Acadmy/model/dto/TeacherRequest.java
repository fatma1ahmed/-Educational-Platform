package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.Enum.EducationalLevel;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    @JsonProperty("teacher_name")
    @NotNull(message = "please,enter your name")
    private String name;
    @JsonProperty("teacher_password")
    @NotNull(message = "please,enter your name")
    @Column(unique = true)
    @Size(min = 8,max = 18,message = "enter your password between 8 and 18 character")
    private String password;
    @JsonProperty("teacher_phone")
    @NotNull(message = "please,enter your phone")
    @Column(unique = true)
    @Pattern(regexp = "\\d{4}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ###-###-#### format.")
    private String phone;
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
