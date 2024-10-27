package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.PdfService;
import com.fatma.Leader_Acadmy.model.dto.PdfRequest;
import com.fatma.Leader_Acadmy.model.dto.PdfResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pdfs")
public class PdfController {
    @Autowired
    private PdfService pdfService;
    @PostMapping
    public PdfResponse add(@RequestBody @Valid PdfRequest Request) {
        return pdfService.add(Request) ;
    }
    @PutMapping("/{id}")
    public PdfResponse update(@RequestBody @Valid PdfRequest Request,@PathVariable long id) {
        return pdfService.update(Request,id);
    }
    @GetMapping("/{id}")
    public PdfResponse getById(@PathVariable long id) {
        return pdfService.getById(id);
    }
    @GetMapping
    public List<PdfResponse> getAll() {
        return pdfService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return pdfService.deleteById(id);
    }
    @GetMapping("/getAllByLessonId/{lessonId}")
    public List<PdfResponse> getAllPdfsByLessonId(@PathVariable long lessonId) {
        return pdfService.getAllPdfsByLessonId(lessonId);
    }
}
