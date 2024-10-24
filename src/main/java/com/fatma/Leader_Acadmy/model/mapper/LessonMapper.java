package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.LessonRequest;
import com.fatma.Leader_Acadmy.model.dto.LessonResponse;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toEntity(LessonRequest lessonRequest);
    @Mapping(target = "subjectId",source = "lesson.subject.id")
    @Mapping(target = "teacherId",source = "lesson.teacher.id")
    @Mapping(target = "packageeId",source = "lesson.packagee.id")
    LessonResponse toResponse(Lesson lesson);
}
