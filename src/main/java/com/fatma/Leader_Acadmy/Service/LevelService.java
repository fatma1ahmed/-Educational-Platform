package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.LevelRequest;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import com.fatma.Leader_Acadmy.model.entity.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface LevelService {
    LevelResponse add(LevelRequest levelRequest);
    LevelResponse update(LevelRequest levelRequest,long id);
    LevelResponse getEntityById(long id);

    List<LevelResponse> getAll();

    ResponseEntity<?> deleteById(long id);
}
