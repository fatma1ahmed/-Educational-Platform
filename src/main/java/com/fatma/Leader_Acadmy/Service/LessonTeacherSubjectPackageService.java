package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.Service.Impl.TeacherServiceImpl;
import com.fatma.Leader_Acadmy.model.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface LessonTeacherSubjectPackageService {

    void assignTeacherAndSubjectAndPackageToLesson(Lesson lesson,long teacherId,long subjectId,long packageId);
}
