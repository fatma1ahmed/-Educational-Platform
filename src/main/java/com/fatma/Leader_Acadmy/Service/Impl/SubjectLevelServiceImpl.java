package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.SubjectLevelService;
import com.fatma.Leader_Acadmy.model.entity.Level;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectLevelServiceImpl implements SubjectLevelService {
    @Autowired
    private LevelServiceImpl levelService;
    @Override
    public void assignLevelToSubject(Subject subject, long levelId) {
        Level level=levelService.getEntityById(levelId);
        subject.setLevel(level);

    }

    @Override
    public void update(Subject subject, long levelId) {
        Level exsistLevel=levelService.getEntityById(levelId);
        subject.setLevel(exsistLevel);

    }
}
