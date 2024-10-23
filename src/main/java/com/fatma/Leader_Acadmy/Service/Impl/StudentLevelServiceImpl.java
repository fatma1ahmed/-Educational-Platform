package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Service.LevelService;
import com.fatma.Leader_Acadmy.Service.StudentLevelService;
import com.fatma.Leader_Acadmy.model.entity.Level;
import com.fatma.Leader_Acadmy.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLevelServiceImpl implements StudentLevelService {
    @Autowired
 private LevelServiceImpl levelService;
    @Override
    public void assignLevelToStudent(Student student, long levelId) {
        Level level=levelService.getEntityById(levelId);
        student.setLevel(level);


    }

    @Override
    public void update(Student student, long levelId) {
        Level exisitlevel=levelService.getEntityById(levelId);
        student.setLevel(exisitlevel);

    }
}
