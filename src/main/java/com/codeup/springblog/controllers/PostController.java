package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String postId(@PathVariable long id) {
        return "View an individual post";
        //http://localhost:8080/posts/1
    }

    //When you visit the URL you will see the form to create a post.
    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateGet() {
        return "view the form for creating a post 'Create a post'";
        //http://localhost:8080/posts/create
    }

    //When you submit the form on the /posts/create page,
    //the information will be posted to the same URL.
    //    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create new post.";
    }
}
