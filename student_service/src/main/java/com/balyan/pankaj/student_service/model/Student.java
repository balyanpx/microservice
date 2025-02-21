package com.balyan.pankaj.student_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
@Data @NoArgsConstructor @AllArgsConstructor
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private Long schoolId;
}
