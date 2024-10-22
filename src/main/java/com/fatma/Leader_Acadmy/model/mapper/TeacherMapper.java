package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.TeacherRequest;
import com.fatma.Leader_Acadmy.model.dto.TeacherResponse;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(TeacherRequest teacherRequest);
    @Mapping(target = "subjectId",source = "teacher.subject.id")
    @Mapping(target = "levelId",source = "teacher.level.id")
    TeacherResponse toResponse(Teacher teacher);
}
