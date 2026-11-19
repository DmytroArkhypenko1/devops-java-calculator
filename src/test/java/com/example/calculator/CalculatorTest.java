package com.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private static final double DELTA = 0.000000001;

    @Test
    void shouldAddTwoPositiveNumbers() {
        assertEquals(5.0, Calculator.add(2, 3), DELTA);
    }

    @Test
    void shouldAddNegativeNumbers() {
        assertEquals(-5.0, Calculator.add(-2, -3), DELTA);
    }

    @Test
    void shouldAddPositiveAndNegativeNumbers() {
        assertEquals(2.0, Calculator.add(5, -3), DELTA);
    }

    @Test
    void shouldHandleZero() {
        assertEquals(5.0, Calculator.add(5, 0), DELTA);
    }

    @Test
    void shouldAddDecimalNumbers() {
        assertEquals(0.3, Calculator.add(0.1, 0.2), DELTA);
    }

    @Test
    void shouldSubtractPositiveNumbers() {
        assertEquals(5.0, Calculator.subtract(8, 3), DELTA);
    }

    @Test
    void shouldReturnNegativeSubtractionResult() {
        assertEquals(-5.0, Calculator.subtract(3, 8), DELTA);
    }

    @Test
    void shouldSubtractNegativeNumbers() {
        assertEquals(1.0, Calculator.subtract(-2, -3), DELTA);
    }

    @Test
    void shouldSubtractZero() {
        assertEquals(5.0, Calculator.subtract(5, 0), DELTA);
    }

    @Test
    void shouldSubtractDecimalNumbers() {
        assertEquals(3.3, Calculator.subtract(5.5, 2.2), DELTA);
    }

    @Test
    void shouldReturnPositiveInfinityOnAdditionOverflow() {
        double result = Calculator.add(
            Double.MAX_VALUE,
            Double.MAX_VALUE
        );

        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    void shouldReturnNegativeInfinityOnAdditionOverflow() {
        double result = Calculator.add(
            -Double.MAX_VALUE,
            -Double.MAX_VALUE
        );

        assertEquals(Double.NEGATIVE_INFINITY, result);
    }
}