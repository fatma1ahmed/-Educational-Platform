package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.entity.Pdf;
import org.springframework.stereotype.Service;

@Service
public interface PdfLessonService {
    void assignLessonToPdf(Pdf pdf,long lessonId);
}
