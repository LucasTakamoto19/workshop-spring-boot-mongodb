package com.lucastakamoto.workshopmongo.controller;

import com.lucastakamoto.workshopmongo.controller.util.URL;
import com.lucastakamoto.workshopmongo.domain.Post;
import com.lucastakamoto.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(value = "/tittlesearch")
    public ResponseEntity <List<Post>> findByTittle(@RequestParam(value = "text", defaultValue = "") String text){

        // Decodifica o texto
        text = URL.decodeParam(text);

        List<Post> list = postService.findByTittle(text);
        return ResponseEntity.ok().body(list);
    }
}
