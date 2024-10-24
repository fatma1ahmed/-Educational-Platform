package com.fatma.Leader_Acadmy.Controller;

import com.fatma.Leader_Acadmy.Service.Impl.StudentServiceImpl;
import com.fatma.Leader_Acadmy.Service.StudentService;
import com.fatma.Leader_Acadmy.model.dto.StudentRequest;
import com.fatma.Leader_Acadmy.model.dto.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @PostMapping
    public StudentResponse add(@RequestBody @Valid StudentRequest Request) {
        return studentService.add(Request);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@RequestBody @Valid StudentRequest Request,@PathVariable long id) {
        return studentService.update(Request,id);
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable long id) {

        return studentService.getById(id) ;
    }
   @GetMapping
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return new ResponseEntity<>(studentService.deleteById(id),HttpStatus.ACCEPTED);
   }


   @PostMapping("/login")
    public StudentResponse login(@RequestParam  String phone, @RequestParam String password) {
        return studentService.login(phone,password);
    }
    @PostMapping("/assignSubjectToStudent/{studentId}/{subjectId}")
    public ResponseEntity<?> assignSubjectToStudent(@PathVariable int studentId,@PathVariable int subjectId){
        return studentServiceImpl.assignSubjectToStudent(studentId,subjectId);

    }
}
