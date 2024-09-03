package com.lucastakamoto.workshopmongo.controller;

import com.lucastakamoto.workshopmongo.domain.Post;
import com.lucastakamoto.workshopmongo.domain.User;
import com.lucastakamoto.workshopmongo.dto.UserDTO;
import com.lucastakamoto.workshopmongo.service.PostService;
import com.lucastakamoto.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity <Post> findById(@PathVariable String id){

        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
