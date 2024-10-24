package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.StudentRepo;
import com.fatma.Leader_Acadmy.Service.StudentLevelService;
import com.fatma.Leader_Acadmy.Service.StudentService;
import com.fatma.Leader_Acadmy.Service.SubjectService;
import com.fatma.Leader_Acadmy.exception.DuplicateRecordException;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.StudentRequest;
import com.fatma.Leader_Acadmy.model.dto.StudentResponse;
import com.fatma.Leader_Acadmy.model.entity.Student;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentLevelService studentLevelService;
    @Autowired
    private SubjectServiceImpl subjectService;
    @Override
    public StudentResponse add(StudentRequest Request) {
        Student student=studentMapper.toEntity(Request);
        long levelId=Request.getLevelId();
        Optional<Student> student1=studentRepo.findByPhone(student.getPhone());
        if(student1.isPresent()){
          throw new DuplicateRecordException("student with this phone already found with anther user");
        }
        studentLevelService.assignLevelToStudent(student,levelId);

        return studentMapper.toResponse(studentRepo.save(student));
    }

    @Override
    public StudentResponse update(StudentRequest Request, long id) {
        getEntityById(id);
        Student student=studentMapper.toEntity(Request);
        studentLevelService.update(student,Request.getLevelId());
        student.setId(id);
        return studentMapper.toResponse(studentRepo.save(student));
    }

    @Override
    public StudentResponse getById(long id) {
        Student student=studentRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this student with id " + id + "not found")
        );
        return studentMapper.toResponse(student)  ;
    }
    public Student getEntityById(long id) {
        return studentRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this student with id " + id + "not found")
        );
    }

    @Override
    public List<StudentResponse> getAll() {
        return studentRepo.findAll().stream().map(
                studentMapper::toResponse
        ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        studentRepo.deleteById(id);
        return new ResponseEntity<>("student with id " + id + "deleted succesfully", HttpStatus.ACCEPTED);
    }


  private Optional<Student> findByPhone(String phone) {
        return studentRepo.findByPhone(phone);
    }

    @Override
    public StudentResponse login(String phone, String password) {
        Optional<Student> student=studentRepo.findByPhoneAndPassword(phone,password);
        return studentMapper.toResponse(student.get());
    }
    public ResponseEntity<?> assignSubjectToStudent(int studentId,int subjectId){
        Student student=getEntityById(studentId);
        Subject subject=subjectService.getEntityById(subjectId);
        student.getSubjects().add(subject);
        return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);
    }
}
