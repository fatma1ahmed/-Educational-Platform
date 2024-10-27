package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.Service.CrudService;
import com.fatma.Leader_Acadmy.model.dto.PdfRequest;
import com.fatma.Leader_Acadmy.model.dto.PdfResponse;
import com.fatma.Leader_Acadmy.model.entity.Pdf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PdfService extends CrudService<Pdf, PdfRequest, PdfResponse> {
    List<PdfResponse> getAllPdfsByLessonId(long lessonId);
}
