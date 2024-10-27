package com.fatma.Leader_Acadmy.Repository;

import com.fatma.Leader_Acadmy.model.entity.Pdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PdfRepo extends JpaRepository<Pdf,Long> {
    List<Pdf> findAllByLessonId(long lessonId);
}
