package com.fatma.Leader_Acadmy.Service;


import com.fatma.Leader_Acadmy.model.dto.VideoRequest;
import com.fatma.Leader_Acadmy.model.dto.VideoResponse;
import com.fatma.Leader_Acadmy.model.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService extends CrudService<Video, VideoRequest, VideoResponse> {
    List<VideoResponse> getAllVideosByLessonId(long lessonId);
}
