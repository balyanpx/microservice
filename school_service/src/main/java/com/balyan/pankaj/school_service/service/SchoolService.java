package com.balyan.pankaj.school_service.service;

import com.balyan.pankaj.school_service.model.School;
import com.balyan.pankaj.school_service.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepos;

    public School addSchool(School school){
        return schoolRepos.save(school);
    }

    public List<School> getAll(){
        return schoolRepos.findAll();
    }

    public School getById(Long id){
        return schoolRepos.findById(id).orElse(null);
    }
}
