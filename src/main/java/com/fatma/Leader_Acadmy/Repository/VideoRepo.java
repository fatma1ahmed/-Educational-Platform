package com.fatma.Leader_Acadmy.Repository;

import com.fatma.Leader_Acadmy.model.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {
    List<Video> findAllByLessonId(long lessonId);
}
