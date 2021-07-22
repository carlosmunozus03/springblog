package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {

    private int roll = 0;

    @GetMapping("/roll-dice")
    public String Guess() {
        roll = dice();
        return "dice-guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String GuessResponse(@PathVariable int n, Model model) {

        boolean guessCorrect = false;
        if (n == roll) {
            guessCorrect = true;
        }

        model.addAttribute("roll", roll);
        model.addAttribute("n", n);
        model.addAttribute("guessCorrect", guessCorrect);

        return "dice-results";
    }

    public int dice() {
        int n = 6;
        int roll = (int) (Math.random() * n) + 1;
        return roll;
    }
}