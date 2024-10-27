package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.PdfLessonService;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import com.fatma.Leader_Acadmy.model.entity.Pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfLessonServiceImpl implements PdfLessonService {
    @Autowired
    private LessonServiceImpl lessonService;
    @Override
    public void assignLessonToPdf(Pdf pdf, long lessonId) {
        Lesson lesson=lessonService.getEntityById(lessonId);
        pdf.setLesson(lesson);

    }
}
