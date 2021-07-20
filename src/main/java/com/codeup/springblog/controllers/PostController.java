package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String post() {
        return "posts index page";
        //http://localhost:8080/posts
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public int postId(@PathVariable int id) {
        return id;
        //http://localhost:8080/posts/1
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateGet() {
        return "view the form for creating a post";
        //http://localhost:8080/posts/create
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatePost() {
        return "create a new post";
        //http://localhost:8080/posts/create
    }
}
