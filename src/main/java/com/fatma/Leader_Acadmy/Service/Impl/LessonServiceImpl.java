package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.LessonRepo;
import com.fatma.Leader_Acadmy.Repository.LevelRepo;
import com.fatma.Leader_Acadmy.Service.LessonService;
import com.fatma.Leader_Acadmy.Service.LessonTeacherSubjectPackageService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.LessonRequest;
import com.fatma.Leader_Acadmy.model.dto.LessonResponse;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import com.fatma.Leader_Acadmy.model.mapper.LessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepo lessonRepo;
    @Autowired
    private LessonMapper lessonMapper;
    @Autowired
    private LessonTeacherSubjectPackageService lessonTeacherSubjectPackageService;

    @Override
    public LessonResponse add(LessonRequest Request) {
        Lesson lesson=lessonMapper.toEntity(Request);
        lessonTeacherSubjectPackageService.assignTeacherAndSubjectAndPackageToLesson(lesson, Request.getTeacherId(), Request.getSubjectId(),Request.getPackageeId());

        return lessonMapper.toResponse(lessonRepo.save(lesson));
    }

    @Override
    public LessonResponse update(LessonRequest Request, long id) {
        getEntityById(id);
        Lesson lesson=lessonMapper.toEntity(Request);
        lessonTeacherSubjectPackageService.assignTeacherAndSubjectAndPackageToLesson(lesson, Request.getTeacherId(), Request.getSubjectId(),Request.getPackageeId());
        lesson.setId(id);
        return lessonMapper.toResponse(lessonRepo.save(lesson));
    }

    @Override
    public LessonResponse getById(long id) {
        Lesson lesson=lessonRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("lesson with id: " + id + " not found")
        ) ;
        return lessonMapper.toResponse(lesson);
    }
    public Lesson getEntityById(long id) {
        return lessonRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("lesson with id: " + id + " not found")
        ) ;
    }

    @Override
    public List<LessonResponse> getAll() {
        return lessonRepo.findAll().stream().map(
                lessonMapper::toResponse
        ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        lessonRepo.deleteById(id);

        return new ResponseEntity<>("this lesson with id: " + id + "deleted", HttpStatus.ACCEPTED);
    }

    @Override
    public List<LessonResponse> getAllByPackageId(long packageeId) {
        return lessonRepo.findAllByPackageeId(packageeId).stream().map(
                lessonMapper::toResponse
        ).collect(Collectors.toList());
    }
}
