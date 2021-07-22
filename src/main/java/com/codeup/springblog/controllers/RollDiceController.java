package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    private int roll = 0;

    @GetMapping("/roll-dice")
    public String guess() {
        roll = dice();
        return "guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessResponse(@PathVariable int n, Model model) {

        boolean guessCorrect = n == roll;

        model.addAttribute("roll", roll);
        model.addAttribute("n", n);
        model.addAttribute("guessCorrect", guessCorrect);

        return "results";
    }

    public int dice() {
        int n = 6;
        return (int) (Math.random() * n) + 1;
    }
}