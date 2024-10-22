package com.fatma.Leader_Acadmy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfResponse {
    @JsonProperty("pdf_id")
    private long id;
    @JsonProperty("pdf_title")
    private String title;
    @Column(length = 5000)
    @JsonProperty("pdf_description")
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("pdf_url")
    private String url;
    @JsonProperty("lesson_id")
    private long lessonId;
}
