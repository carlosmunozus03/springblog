package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    List<Post> post = Arrays.asList(
            new Post("Languages", "Always Learn another language, it could be person to person or person to machine"),
            new Post("Neptune Cohort 2021!", "The best cohort in the codeup history!"),
            new Post("Birds!", "Her love birding..."),
            new Post("Airports", "Lost in the huge airports sometimes...")
    );

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("Posts", post);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id, Model model) {
        Post post = new Post("Test post", "test describe");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createGet() {
        return "Form for creating a post(Get)";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post here(com.example.blog.models.Post)";
    }

}