package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.entity.Video;
import org.springframework.stereotype.Service;

@Service
public interface VideoLessonService  {
    void assignLessonToVideo(Video video, long lessonId);
}
