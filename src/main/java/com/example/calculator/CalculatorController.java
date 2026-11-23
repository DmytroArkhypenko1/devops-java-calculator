package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/")
    public String calculate(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b,
            @RequestParam(name = "operation") String operation,
            Model model) {

        double result = switch (operation) {
            case "add" -> Calculator.add(a, b);
            case "subtract" -> Calculator.subtract(a, b);
            case "multiply" -> Calculator.multiply(a, b);
            case "divide" -> Calculator.divide(a, b);
            default -> throw new IllegalArgumentException(
                    "Unsupported operation."
            );
        };

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        return "index";
    }
}
