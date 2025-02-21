package com.balyan.pankaj.student_service.controller;

import com.balyan.pankaj.student_service.model.Student;
import com.balyan.pankaj.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService stuService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        return stuService.createStudent(student);
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        return stuService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id){
        return stuService.getStudentById(id);
    }
}
