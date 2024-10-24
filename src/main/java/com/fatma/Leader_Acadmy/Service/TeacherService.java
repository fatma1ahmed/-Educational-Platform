package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.TeacherRequest;
import com.fatma.Leader_Acadmy.model.dto.TeacherResponse;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService extends CrudService<Teacher, TeacherRequest,TeacherResponse>{
    List<TeacherResponse> getAllTeachersByLevelId(long levelId);
}
