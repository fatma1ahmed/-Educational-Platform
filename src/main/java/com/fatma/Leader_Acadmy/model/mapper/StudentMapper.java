package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.StudentRequest;
import com.fatma.Leader_Acadmy.model.dto.StudentResponse;
import com.fatma.Leader_Acadmy.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest studentRequest);
    @Mapping(target = "levelId",source = "student.level.id")
    StudentResponse toResponse(Student student);
}
