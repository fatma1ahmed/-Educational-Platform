package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherSubjectLevelService {
    void assignLevelAndSubjectToTeacher(Teacher teacher,long subjectId,long levelId);
    void update(Teacher teacher,long subjectId,long levelId);
}
