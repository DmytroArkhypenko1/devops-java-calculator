package com.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static final double DELTA = 0.000000001;
    // ======================== Addition Tests  ======================== 
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


    // ======================== Subtraction Tests  ======================== 
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

    // ======================== Double Boundaries Tests  ======================== 
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

    // ======================== Multiplication Tests  ======================== 
    @Test
    void shouldMultiplyPositiveNumbers() {
        assertEquals(12.0, Calculator.multiply(4, 3), DELTA);
    }

    @Test
    void shouldMultiplyNumbersWithDifferentSigns() {
        assertEquals(-12.0, Calculator.multiply(-4, 3), DELTA);
    }

    @Test
    void shouldMultiplyNegativeNumbers() {
        assertEquals(12.0, Calculator.multiply(-4, -3), DELTA);
    }

    @Test
    void shouldMultiplyWithZeroAsFirstOperand() {
        assertEquals(0.0, Calculator.multiply(0, 7), DELTA);
    }

    @Test
    void shouldMultiplyWithZeroAsSecondOperand() {
        assertEquals(0.0, Calculator.multiply(7, 0), DELTA);
    }

    @Test
    void shouldMultiplyDecimalNumbers() {
        assertEquals(3.0, Calculator.multiply(2.5, 1.2), DELTA);
    }

    // ======================== Division Tests  ======================== 
    @Test
    void shouldDividePositiveNumbers() {
        assertEquals(4.0, Calculator.divide(8, 2), DELTA);
    }

    @Test
    void shouldReturnFractionalDivisionResult() {
        assertEquals(2.5, Calculator.divide(5, 2), DELTA);
    }

    @Test
    void shouldDivideNegativeDivident() {
        assertEquals(-3.0, Calculator.divide(-9, 3), DELTA);
    }

    @Test
    void shouldDivideByNegativeDivisor() {
        assertEquals(-3.0, Calculator.divide(9, -3), DELTA);
    }

    @Test
    void shouldDivideNegativeNumbers() {
        assertEquals(3.0, Calculator.divide(-9, -3), DELTA);
    }

    @Test
    void shouldDivideZeroByNonZeroNumber() {
        assertEquals(0.0, Calculator.divide(0, 5), DELTA);
    }

    @Test
    void shouldDivideDecimalNumbers() {
        assertEquals(3.0, Calculator.divide(7.5, 2.5), DELTA);
    }

    @Test
    void shouldRejectDivisionByZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Calculator.divide(5, 0.0)
        );

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
    
    @Test
    void shouldRejectDivisionByNegativeZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Calculator.divide(5, -0.0)
        );

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    void shouldRejectZeroDividedByZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Calculator.divide(0, 0)
        );

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}