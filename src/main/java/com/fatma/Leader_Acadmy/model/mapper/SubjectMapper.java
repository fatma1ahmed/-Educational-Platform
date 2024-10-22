package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.SubjectRequest;
import com.fatma.Leader_Acadmy.model.dto.SubjectResponse;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toEntity(SubjectRequest subjectRequest);
    @Mapping(target = "levelId",source = "subject.level.id")
    SubjectResponse toResponse(Subject subject);

}
