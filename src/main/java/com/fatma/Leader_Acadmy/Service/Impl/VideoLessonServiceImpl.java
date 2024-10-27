package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.VideoLessonService;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import com.fatma.Leader_Acadmy.model.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoLessonServiceImpl implements VideoLessonService {
    @Autowired
    private LessonServiceImpl lessonService;
    @Override
    public void assignLessonToVideo(Video video, long lessonId) {
        Lesson lesson=lessonService.getEntityById(lessonId);
        video.setLesson(lesson);

    }
}
