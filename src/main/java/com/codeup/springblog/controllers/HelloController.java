package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello from Spring!</h1>";
    }

    //the example below is with a String variable name
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
        //http://localhost:8080/hello/carlos
    }

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
