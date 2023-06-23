package com.rahul.joblisting.controller;

import com.rahul.joblisting.model.Post;
import com.rahul.joblisting.repository.PostRepository;
import com.rahul.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController
{
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/allPosts")
    @CrossOrigin
    public List<Post> getAllPost(){
        return repo.findAll();
    }

    @GetMapping(value = "/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping(value = "post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

}
