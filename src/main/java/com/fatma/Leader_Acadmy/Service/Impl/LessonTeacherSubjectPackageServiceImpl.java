package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.LessonTeacherSubjectPackageService;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import com.fatma.Leader_Acadmy.model.entity.Package;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonTeacherSubjectPackageServiceImpl implements LessonTeacherSubjectPackageService {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private SubjectServiceImpl subjectService;
    @Autowired
    private PackageServiceImpl packageService;

    @Override
    public void assignTeacherAndSubjectAndPackageToLesson(Lesson lesson, long teacherId, long subjectId, long packageId) {
        Teacher teacher=teacherService.getEntityById(teacherId);
        Subject subject=subjectService.getEntityById(subjectId);
        Package packagee=packageService.getEntityById(packageId);
        lesson.setTeacher(teacher);
        lesson.setSubject(subject);
        lesson.setPackagee(packagee);

    }
}
