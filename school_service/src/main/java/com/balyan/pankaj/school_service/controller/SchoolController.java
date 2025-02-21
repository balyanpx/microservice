package com.balyan.pankaj.school_service.controller;


;
import com.balyan.pankaj.school_service.model.School;
import com.balyan.pankaj.school_service.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/school")
@CrossOrigin("*")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @PostMapping
    public School addSchool(@RequestBody School school){
        return service.addSchool(school);
    }

    @GetMapping
    public List<School> getSchoolList(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id){
        return service.getById(id);
    }
}
