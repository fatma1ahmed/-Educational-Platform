package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.PackageService;
import com.fatma.Leader_Acadmy.model.dto.PackageRequest;
import com.fatma.Leader_Acadmy.model.dto.PackageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {
    @Autowired
    private PackageService packageService;
    @PostMapping
    public PackageResponse add(@RequestBody PackageRequest Request) {
        return packageService.add(Request);
    }
    @PutMapping("/{id}")
    public PackageResponse update(@RequestBody PackageRequest Request,@PathVariable long id) {
        return packageService.update(Request,id);
    }
    @GetMapping("/{id}")
    public PackageResponse getById(@PathVariable long id) {
        return packageService.getById(id);
    }
    @GetMapping
    public List<PackageResponse> getAll() {
        return packageService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(long id) {
        return packageService.deleteById(id);
    }
    @GetMapping("getPackages/{teacherId}/{levelId}")
    public List<PackageResponse> findAllByTeacherIdAndLevelId(@PathVariable long teacherId, @PathVariable long levelId){
        return packageService.findAllByTeacherIdAndLevelId(teacherId,levelId);
    }


}
