package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.TeacherService;
import com.fatma.Leader_Acadmy.model.dto.TeacherRequest;
import com.fatma.Leader_Acadmy.model.dto.TeacherResponse;
import com.fatma.Leader_Acadmy.model.entity.Teacher;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping
    public TeacherResponse add(@RequestBody @Valid TeacherRequest Request) {
        return teacherService.add(Request);
    }
    @PutMapping("/{id}")
    public TeacherResponse update(@RequestBody @Valid TeacherRequest Request,@PathVariable long id) {
        return teacherService.update(Request,id);
    }
    @GetMapping("/{id}")
    public TeacherResponse getById(@PathVariable long id) {
        return teacherService.getById(id);
    }
    @GetMapping
    public List<TeacherResponse> getAll() {
        return teacherService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return teacherService.deleteById(id);

    }
    @GetMapping("level/{levelId}")
    public List<TeacherResponse> getAllTeachersByLevelId(@PathVariable long levelId){
        return teacherService.getAllTeachersByLevelId(levelId);
    }
}
