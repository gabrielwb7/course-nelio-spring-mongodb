package com.gabrielr.courseneliospringmongodb.resources;

import com.gabrielr.courseneliospringmongodb.domain.Post;
import com.gabrielr.courseneliospringmongodb.resources.util.URL;
import com.gabrielr.courseneliospringmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = service.findAll();

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }


    @GetMapping("titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        List<Post> posts = service.findByTitle(text);

        return ResponseEntity.ok().body(posts);
    }

}
