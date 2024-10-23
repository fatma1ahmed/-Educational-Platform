package com.fatma.Leader_Acadmy.Service;

import com.fatma.Leader_Acadmy.model.dto.LevelRequest;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<Entity, Request, Response>{
    Response add(Request Request);
    Response update(Request Request,long id);
    Response getById(long id);

    List<Response> getAll();

    ResponseEntity<?> deleteById(long id);
}
