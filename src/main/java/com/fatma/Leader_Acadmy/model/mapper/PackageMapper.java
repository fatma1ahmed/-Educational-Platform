package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.PackageRequest;
import com.fatma.Leader_Acadmy.model.dto.PackageResponse;
import com.fatma.Leader_Acadmy.model.entity.Package;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PackageMapper {
    Package toEntity(PackageRequest packageRequest);
    @Mapping(target = "subjectId",source = "packagee.subject.id")
    @Mapping(target = "levelId",source = "packagee.level.id")
    @Mapping(target = "teacherId",source = "packagee.teacher.id")
    PackageResponse toResponse(Package packagee);
}
