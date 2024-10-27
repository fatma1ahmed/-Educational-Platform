package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.LessonRequest;
import com.fatma.Leader_Acadmy.model.dto.LessonResponse;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService extends CrudService<Lesson, LessonRequest, LessonResponse> {
    List<LessonResponse> getAllByPackageId(long packageeId);
}
