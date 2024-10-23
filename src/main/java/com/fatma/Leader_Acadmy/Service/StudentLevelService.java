package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.StudentRequest;
import com.fatma.Leader_Acadmy.model.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentLevelService {
   void assignLevelToStudent(Student student, long levelId);
   void update(Student student, long levelId);
}
