package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.VideoService;

import com.fatma.Leader_Acadmy.model.dto.VideoRequest;
import com.fatma.Leader_Acadmy.model.dto.VideoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @PostMapping
    public VideoResponse add(@RequestBody @Valid VideoRequest Request) {
        return videoService.add(Request) ;
    }
    @PutMapping("/{id}")
    public VideoResponse update(@RequestBody @Valid VideoRequest Request,@PathVariable long id) {
        return videoService.update(Request,id);
    }
    @GetMapping("/{id}")
    public VideoResponse getById(@PathVariable long id) {
        return videoService.getById(id);
    }
    @GetMapping
    public List<VideoResponse> getAll() {
        return videoService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return videoService.deleteById(id);
    }
    @GetMapping("/getAllByLessonId/{lessonId}")
    public List<VideoResponse> getAllPdfsByLessonId(@PathVariable long lessonId) {
        return videoService.getAllVideosByLessonId(lessonId);
    }
}
