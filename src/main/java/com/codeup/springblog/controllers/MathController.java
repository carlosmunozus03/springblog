package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @ResponseBody
    @GetMapping("/add/{a}/and/{b}")
    public double add(@PathVariable double a, @PathVariable double b) {
        return a + b;
        //http://localhost:8080/add/3/and/4
    }

    @ResponseBody
    @GetMapping("/subtract/{a}/from/{b}")
    public double subtract(@PathVariable double a, @PathVariable double b) {
        return b - a;
        ////http://localhost:8080/subtract/3/from/10
    }

    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public double multiply(@PathVariable double a, @PathVariable double b) {
        return a * b;
        //http://localhost:8080/multiply/4/and/5
    }

    @ResponseBody
    @GetMapping("/divide/{numerator}/by/{denominator}")
    public double divide(@PathVariable double numerator, @PathVariable double denominator) {
        return numerator / denominator;
        //http://localhost:8080/divide/6/by/3
    }
}