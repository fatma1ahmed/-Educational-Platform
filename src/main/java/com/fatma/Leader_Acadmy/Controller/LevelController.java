package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.LevelService;
import com.fatma.Leader_Acadmy.exception.RecordNotFoundException;
import com.fatma.Leader_Acadmy.model.dto.LevelRequest;
import com.fatma.Leader_Acadmy.model.dto.LevelResponse;
import com.fatma.Leader_Acadmy.model.entity.Level;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Levels")
public class LevelController {
    @Autowired
    private LevelService levelService;
    @PostMapping
    public LevelResponse add(@RequestBody @Valid LevelRequest levelRequest) {
        return levelService.add(levelRequest);
    }

   @PutMapping("/{id}")
    public LevelResponse update(@RequestBody @Valid LevelRequest levelRequest,@PathVariable long id) {

        return levelService.update(levelRequest,id);
    }

    @GetMapping("/{id}")
    public LevelResponse getEntityById(@PathVariable long id) {
      return levelService.getEntityById(id);
    }

   @GetMapping
    public List<LevelResponse> getAll() {
      return levelService.getAll();
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
      return levelService.deleteById(id);
    }
}
