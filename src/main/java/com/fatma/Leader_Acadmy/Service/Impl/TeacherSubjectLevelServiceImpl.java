package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.TeacherSubjectLevelService;
import com.fatma.Leader_Acadmy.model.entity.Level;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherSubjectLevelServiceImpl implements TeacherSubjectLevelService {
    @Autowired
    private LevelServiceImpl levelService;
    @Autowired
    private SubjectServiceImpl subjectService;
    @Override
    public void assignLevelAndSubjectToTeacher(Teacher teacher, long subjectId, long levelId) {
        Level level=levelService.getEntityById(levelId);
        Subject subject=subjectService.getEntityById(subjectId);
        teacher.setLevel(level);
        teacher.setSubject(subject);
    }

    @Override
    public void update(Teacher teacher, long subjectId, long levelId) {
        Level exsistlevel=levelService.getEntityById(levelId);
        Subject exsistsubject=subjectService.getEntityById(subjectId);
        teacher.setLevel(exsistlevel);
        teacher.setSubject(exsistsubject);

    }
}
