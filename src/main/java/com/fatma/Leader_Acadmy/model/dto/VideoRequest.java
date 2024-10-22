package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
    @JsonProperty("video_title")
    @NotNull(message = "please,enter title video")
    private String title;
    @Column(length = 5000)
    @JsonProperty("video_description")
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("video_url")
    private String url;
    @JsonProperty("lesson_id")
    private long lessonId;

}
