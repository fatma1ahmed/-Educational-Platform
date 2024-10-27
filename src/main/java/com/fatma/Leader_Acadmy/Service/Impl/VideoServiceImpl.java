package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.VideoRepo;
import com.fatma.Leader_Acadmy.Service.VideoLessonService;
import com.fatma.Leader_Acadmy.Service.VideoService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.VideoRequest;
import com.fatma.Leader_Acadmy.model.dto.VideoResponse;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import com.fatma.Leader_Acadmy.model.entity.Video;
import com.fatma.Leader_Acadmy.model.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl  implements VideoService {
    @Autowired
    private VideoRepo videoRepo;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoLessonService videoLessonService;
    @Override
    public VideoResponse add(VideoRequest Request) {
        Video video=videoMapper.toEntity(Request);
        videoLessonService.assignLessonToVideo(video,Request.getLessonId());
        return videoMapper.toResponse(videoRepo.save(video));
    }

    @Override
    public VideoResponse update(VideoRequest Request, long id) {
        getEntityById(id);
        Video video=videoMapper.toEntity(Request);
        videoLessonService.assignLessonToVideo(video,Request.getLessonId());
        video.setId(id);
        return videoMapper.toResponse(videoRepo.save(video));
    }

    @Override
    public VideoResponse getById(long id) {
        Video video=videoRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this video with id " + id + "not found")
        );
        return videoMapper.toResponse(video);
    }
    public Video getEntityById(long id) {
        return videoRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this video with id " + id + "not found")
        );

    }

    @Override
    public List<VideoResponse> getAll() {
        return videoRepo.findAll().stream().map(videoMapper::toResponse).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        videoRepo.deleteById(id);
        return new ResponseEntity<>("video with id " + id + "deleted successfully", HttpStatus.ACCEPTED);
    }
//    private void checkIfVideosExisitForLessonOrNot(long lessonId) {
//
//        if (getAllVideosByLessonId(lessonId).isEmpty()){
//            throw new RecordNotFoundException("No videos found for this lesson.");
//        }
//
//       }

    @Override
    public List<VideoResponse> getAllVideosByLessonId(long lessonId) {

//       checkIfVideosExisitForLessonOrNot(lessonId);
        return videoRepo.findAllByLessonId(lessonId).stream().map(videoMapper::toResponse).collect(Collectors.toList());
    }
}
