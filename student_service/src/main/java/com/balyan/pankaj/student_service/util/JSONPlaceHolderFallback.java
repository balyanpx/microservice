package com.balyan.pankaj.student_service.util;

import com.balyan.pankaj.student_service.dto.Post;
import com.balyan.pankaj.student_service.service.JSONPlaceHolderClient;

import java.util.List;

public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {
    @Override
    public List<Post> getPosts() {
        return List.of();
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }
}
