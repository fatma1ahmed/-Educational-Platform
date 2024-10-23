package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.SubjectService;
import com.fatma.Leader_Acadmy.model.dto.SubjectRequest;
import com.fatma.Leader_Acadmy.model.dto.SubjectResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @PostMapping
    public SubjectResponse add(@RequestBody @Valid SubjectRequest Request) {
        return subjectService.add(Request);
    }

   @PutMapping("/{id}")
    public SubjectResponse update(@RequestBody @Valid SubjectRequest Request,@PathVariable long id) {

        return subjectService.update(Request,id);
    }

   @GetMapping("/{id}")
    public SubjectResponse getById(@PathVariable long id) {

        return subjectService.getById(id);
    }
    @GetMapping
    public List<SubjectResponse> getAll() {
        return subjectService.getAll();
    }
@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {

        return subjectService.deleteById(id);
    }
}
