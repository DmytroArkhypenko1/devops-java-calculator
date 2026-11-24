package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculatorControllerTest {

    private final CalculatorController controller =
            new CalculatorController();

    @Test
    void shouldReturnCalculatorView() {
        assertEquals("index", controller.showForm());
    }

    @Test
    void shouldHandleAddition() {
        assertCalculation("add", 10.0);
    }

    @Test
    void shouldHandleSubtraction() {
        assertCalculation("subtract", 6.0);
    }

    @Test
    void shouldHandleMultiplication() {
        assertCalculation("multiply", 16.0);
    }

    @Test
    void shouldHandleDivision() {
        assertCalculation("divide", 4.0);
    }

    @Test
    void shouldDisplayErrorForUnsupportedOperation() {
        Model model = new ExtendedModelMap();

        String view = controller.calculate(
                "8", "2", "unknown", model
        );

        assertEquals("index", view);
        assertEquals(
                "Select a valid operation.",
                model.getAttribute("error")
        );
        assertNull(model.getAttribute("result"));
    }

    private void assertCalculation(
            String operation,
            double expectedResult) {

        Model model = new ExtendedModelMap();

        String view = controller.calculate(
                "8", "2", operation, model
        );

        assertEquals("index", view);
        assertEquals(expectedResult, model.getAttribute("result"));
        assertEquals("8", model.getAttribute("a"));
        assertEquals("2", model.getAttribute("b"));
        assertEquals(operation, model.getAttribute("operation"));
        assertNull(model.getAttribute("error"));
    }
}