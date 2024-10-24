package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.PackageLevelSubjectTeacherService;
import com.fatma.Leader_Acadmy.model.entity.Level;
import com.fatma.Leader_Acadmy.model.entity.Package;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageLevelSubjectTeacherServiceImpl implements PackageLevelSubjectTeacherService {
    @Autowired
    private LevelServiceImpl levelService;
    @Autowired
    private SubjectServiceImpl subjectService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Override
    public void assignLevelAndSubjectAndTeacherToPackage(Package packagee, long levelId, long subjectId, long teacherId) {
        Level level=levelService.getEntityById(levelId);
        Subject subject=subjectService.getEntityById(subjectId);
        Teacher teacher=teacherService.getEntityById(teacherId);
        packagee.setLevel(level);
        packagee.setSubject(subject);
        packagee.setTeacher(teacher);

    }
}
