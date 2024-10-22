package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.PdfRequest;
import com.fatma.Leader_Acadmy.model.dto.PdfResponse;
import com.fatma.Leader_Acadmy.model.entity.Pdf;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface PdfMapper {
    Pdf toEntity(PdfRequest pdfRequest);
    @Mapping(target="lessonId",source = "pdf.lesson.id")
    PdfResponse toResponse(Pdf pdf);
}
