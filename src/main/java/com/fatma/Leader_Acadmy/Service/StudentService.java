package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.StudentRequest;
import com.fatma.Leader_Acadmy.model.dto.StudentResponse;
import com.fatma.Leader_Acadmy.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentService extends CrudService<Student, StudentRequest, StudentResponse> {
    StudentResponse login(String phone,String password);
}
