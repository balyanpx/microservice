package com.balyan.pankaj.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class StudentResponse {

    private String id;
    private String name;
    private int age;
    private String gender;
    private School school;
    private Post post;
}
