package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.TeacherRepo;
import com.fatma.Leader_Acadmy.Service.TeacherService;
import com.fatma.Leader_Acadmy.Service.TeacherSubjectLevelService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.TeacherRequest;
import com.fatma.Leader_Acadmy.model.dto.TeacherResponse;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import com.fatma.Leader_Acadmy.model.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherSubjectLevelService teacherSubjectLevelService;
    @Override
    public TeacherResponse add(TeacherRequest Request) {
        Teacher teacher=teacherMapper.toEntity(Request);
        teacherSubjectLevelService.assignLevelAndSubjectToTeacher(teacher, Request.getSubjectId(), Request.getLevelId());
        return teacherMapper.toResponse(teacherRepo.save(teacher));
    }

    @Override
    public TeacherResponse update(TeacherRequest Request, long id) {
        getEntityById(id);
        Teacher teacher=teacherMapper.toEntity(Request);
        teacherSubjectLevelService.update(teacher,Request.getSubjectId(), Request.getLevelId());
        teacher.setId(id);
        return teacherMapper.toResponse(teacherRepo.save(teacher));
    }

    @Override
    public TeacherResponse getById(long id) {
        Teacher teacher=teacherRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this teacher with id : " + id + "not found")
        );
        return teacherMapper.toResponse(teacher);
    }
    private Teacher getEntityById(long id) {
        return teacherRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this teacher with id : " + id + "not found")
        );
    }

    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepo.findAll().stream()
                .map(
                        teacherMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        teacherRepo.deleteById(id);
        return new ResponseEntity<>("teacher with id " + id + "deleted successfully", HttpStatus.ACCEPTED);

    }
}
