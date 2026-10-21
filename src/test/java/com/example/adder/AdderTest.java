package com.example.adder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdderTest {

    @Test
    void shouldAddTwoPositiveNumbers() {
        assertEquals(5, Adder.add(2, 3));
    }

    @Test
    void shouldAddNegativeNumbers() {
        assertEquals(-5, Adder.add(-2, -3));
    }

    @Test
    void shouldAddPositiveAndNegativeNumbers() {
        assertEquals(2, Adder.add(5, -3));
    }

    @Test
    void shouldHandleZero() {
        assertEquals(5, Adder.add(5, 0));
    }

    @Test
    void shouldHandleIntegerBoundaries() {
        assertEquals(Integer.MAX_VALUE, Adder.add(Integer.MAX_VALUE, 0));
        assertEquals(Integer.MIN_VALUE, Adder.add(Integer.MIN_VALUE, 0));
    }

    @Test
    void securityTestShouldNotExposeInstanceFields() {
        assertTrue(Adder.class.getDeclaredFields().length == 0);
    }
}