package com.fatma.Leader_Acadmy.Service.Impl;

import com.fatma.Leader_Acadmy.Repository.LevelRepo;
import com.fatma.Leader_Acadmy.Service.LevelService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.LevelRequest;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import com.fatma.Leader_Acadmy.model.entity.Level;
import com.fatma.Leader_Acadmy.model.mapper.LevelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepo levelRepo;
    private final LevelMapper levelMapper;

    public LevelServiceImpl(LevelRepo levelRepo, LevelMapper levelMapper) {
        this.levelRepo = levelRepo;
        this.levelMapper = levelMapper;
    }

    @Override
    public LevelResponse add(LevelRequest levelRequest) {
        return levelMapper.toResponse(levelRepo.save(levelMapper.toEntity(levelRequest)));
    }

    @Override
    public LevelResponse update(LevelRequest levelRequest,long id) {
       getById(id);
      Level level=levelMapper.toEntity(levelRequest);
      level.setId(id);
        return levelMapper.toResponse(levelRepo.save(level));
    }


    private Level getById(long id) {
        return levelRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this level with id : " + id + "not found")
        );
    }

    @Override
    public LevelResponse getEntityById(long id) {
        Level level=levelRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this level with id : " + id + "not found")
        );
        return levelMapper.toResponse(level);
    }

    @Override
    public List<LevelResponse> getAll() {
        return levelRepo.findAll().stream()
                .map(
                        levelMapper::toResponse
                ).toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getEntityById(id);
        levelRepo.deleteById(id);
        return new ResponseEntity<>("this level with id: " + id + "deleted", HttpStatus.ACCEPTED);
    }
}
