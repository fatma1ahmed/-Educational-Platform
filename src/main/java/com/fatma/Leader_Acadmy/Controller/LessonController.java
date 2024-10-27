package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.LessonService;
import com.fatma.Leader_Acadmy.model.dto.LessonRequest;
import com.fatma.Leader_Acadmy.model.dto.LessonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @PostMapping
    public LessonResponse add(@RequestBody @Valid LessonRequest Request) {
        return lessonService.add(Request);
    }
    @PutMapping("/{id}")
    public LessonResponse update(@RequestBody @Valid LessonRequest Request, @PathVariable long id) {
        return lessonService.update(Request,id);
    }
    @GetMapping("/{id}")
    public LessonResponse getById(@PathVariable long id) {
        return lessonService.getById(id);
    }
    @GetMapping
    public List<LessonResponse> getAll() {
        return lessonService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(long id) {
        return lessonService.deleteById(id);
    }
    @GetMapping("/getLessons/{packageeId}")
    public List<LessonResponse> getAllByPackageId(@PathVariable long packageeId) {
        return lessonService.getAllByPackageId(packageeId);
    }
}
