package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.entity.Subject;
import org.springframework.stereotype.Service;

@Service
public interface SubjectLevelService {
    void assignLevelToSubject(Subject subject,long levelId);
    void update (Subject subject,long levelId);
}
