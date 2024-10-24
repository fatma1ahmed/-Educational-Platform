package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.entity.Package;
import org.springframework.stereotype.Service;

@Service
public interface PackageLevelSubjectTeacherService {
    void assignLevelAndSubjectAndTeacherToPackage(Package packagee,long levelId,long subjectId,long teacherId);
}
