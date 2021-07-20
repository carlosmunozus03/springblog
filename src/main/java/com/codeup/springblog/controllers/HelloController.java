package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello from Spring!</h1>";
    }

    //the example below is with a String variable name and added Model and html-hello
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    //Create form start...
    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
    //Create form end...


    //the example below is with a Number variable num
    @GetMapping("/number/{num}")
    @ResponseBody
    public int displayNumber(@PathVariable int num) {
        return num;
        //http://localhost:8080/number/23
    }

    //the example below is with a String variable (CSS)
    @GetMapping("/hello/in/{color}")
    @ResponseBody
    public String helloInColor(@PathVariable String color) {
        return "<h1 style =\"color: " + color + "\">Hello in " + color + "!</h1>";
        //http://localhost:8080/hello/in/green
    }
}
