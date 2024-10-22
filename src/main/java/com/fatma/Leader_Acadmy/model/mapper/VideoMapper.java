package com.fatma.Leader_Acadmy.model.mapper;

import com.fatma.Leader_Acadmy.model.dto.VideoRequest;
import com.fatma.Leader_Acadmy.model.dto.VideoResponse;
import com.fatma.Leader_Acadmy.model.entity.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoMapper {
   Video toEntity(VideoRequest videoRequest);

   VideoResponse toResponse(Video video);
}
