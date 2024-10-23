package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.SubjectRepo;
import com.fatma.Leader_Acadmy.Service.SubjectLevelService;
import com.fatma.Leader_Acadmy.Service.SubjectService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.SubjectRequest;
import com.fatma.Leader_Acadmy.model.dto.SubjectResponse;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectLevelService subjectLevelService;
    @Override
    public SubjectResponse add(SubjectRequest Request) {
        long levelId=Request.getLevelId();
        Subject subject=subjectMapper.toEntity(Request);
        subjectLevelService.assignLevelToSubject(subject,levelId);
        return subjectMapper.toResponse(subjectRepo.save(subject));
    }

    @Override
    public SubjectResponse update(SubjectRequest Request, long id) {
        getEntityById(id);
        Subject subject=subjectMapper.toEntity(Request);
        subjectLevelService.update(subject,Request.getLevelId());
        subject.setId(id);
        return subjectMapper.toResponse(subjectRepo.save(subject));
    }

    @Override
    public SubjectResponse getById(long id) {
        Subject subject=subjectRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this subject with id : " + id + "not found")
        );
        return subjectMapper.toResponse(subject);
    }
    public Subject getEntityById(long id) {
        return subjectRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this subject with id : " + id + "not found")
        ) ;
    }

    @Override
    public List<SubjectResponse> getAll() {
        return subjectRepo.findAll().stream().map(
                subjectMapper::toResponse
        ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        subjectRepo.deleteById(id);
        return new ResponseEntity<>("subject with id " + id + "deleted successfully", HttpStatus.ACCEPTED);
    }
}
