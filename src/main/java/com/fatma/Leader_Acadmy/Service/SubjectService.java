package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.SubjectRequest;
import com.fatma.Leader_Acadmy.model.dto.SubjectResponse;
import com.fatma.Leader_Acadmy.model.entity.Subject;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService extends CrudService<Subject, SubjectRequest, SubjectResponse> {
}
