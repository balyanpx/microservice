package com.balyan.pankaj.student_service.service;

import com.balyan.pankaj.student_service.dto.Post;
import com.balyan.pankaj.student_service.util.FeignClientConfiguration;
import com.balyan.pankaj.student_service.util.JSONPlaceHolderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/",
fallback = JSONPlaceHolderFallback.class, configuration = FeignClientConfiguration.class)
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
    Post getPostById(@PathVariable Long id);
}
