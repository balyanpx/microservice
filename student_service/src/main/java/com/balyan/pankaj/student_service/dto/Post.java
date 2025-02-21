package com.balyan.pankaj.student_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Post {

    private long id;
    private long userId;
    private String title;
    private String body;

}
