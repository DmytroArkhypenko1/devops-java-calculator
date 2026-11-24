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
            @RequestParam(name = "a", required = false) String a,
            @RequestParam(name = "b", required = false) String b,
            @RequestParam(name = "operation", required = false)
            String operation,
            Model model) {

        model.asMap().remove("result");
        model.asMap().remove("error");

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operation", operation);

        if (a == null || b == null || a.isBlank() || b.isBlank()) {
            return showError(model, "Enter both numbers.");
        }

        double first;
        double second;

        try {
            first = Double.parseDouble(a.trim());
            second = Double.parseDouble(b.trim());
        } catch (NumberFormatException exception) {
            return showError(model, "Enter valid finite numbers.");
        }

        if (!Double.isFinite(first) || !Double.isFinite(second)) {
            return showError(model, "Enter valid finite numbers.");
        }

        double result;

        try {
            result = switch (operation == null ? "" : operation) {
                case "add" -> Calculator.add(first, second);
                case "subtract" -> Calculator.subtract(first, second);
                case "multiply" -> Calculator.multiply(first, second);
                case "divide" -> Calculator.divide(first, second);
                default -> throw new IllegalArgumentException(
                        "Unsupported operation."
                );
            };
        } catch (IllegalArgumentException exception) {
            if (!"add".equals(operation)
                    && !"subtract".equals(operation)
                    && !"multiply".equals(operation)
                    && !"divide".equals(operation)) {
                return showError(model, "Select a valid operation.");
            }

            return showError(model, exception.getMessage());
        }

        if (!Double.isFinite(result)) {
            return showError(
                    model,
                    "The result is outside the supported range."
            );
        }

        model.addAttribute("result", result);
        return "index";
    }

    private String showError(Model model, String message) {
        model.addAttribute("error", message);
        return "index";
    }
}
