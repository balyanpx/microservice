package com.balyan.pankaj.student_service.service;

import com.balyan.pankaj.student_service.dto.School;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);

    @Autowired
    private SchoolServiceClient schoolClient;

    @CircuitBreaker(name = "SCHOOL-SERVICE2", fallbackMethod = "getSchoolByIdFallback")
    public School getSchoolById(Long id){
        logger.info("**School feign client to get School details id:->  {}", id);
        return schoolClient.getSchoolById(id);
    }

    public School getSchoolByIdFallback(Long id){
        logger.error("**Error in getting the school details, fallback method id -> {}", id);
        return null;
    }


}
