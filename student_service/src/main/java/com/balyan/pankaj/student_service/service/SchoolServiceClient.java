package com.balyan.pankaj.student_service.service;

import com.balyan.pankaj.student_service.dto.School;
import com.balyan.pankaj.student_service.util.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "SCHOOL-SERVICE",
path = "/school", configuration = FeignClientConfiguration.class)
public interface SchoolServiceClient {

    @GetMapping("/{id}")
    School getSchoolById(@PathVariable Long id);

    @GetMapping
    List<School> getAllSchool();
}
