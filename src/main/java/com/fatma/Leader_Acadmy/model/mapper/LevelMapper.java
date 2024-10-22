package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.LevelRequest;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import com.fatma.Leader_Acadmy.model.entity.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    Level toEntity(LevelRequest levelRequest);
    LevelResponse toResponse(Level level);
}
