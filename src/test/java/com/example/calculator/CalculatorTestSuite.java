package com.example.calculator;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorTest.class,
        CalculatorControllerTest.class,
        CalculatorValidationTest.class
})
public class CalculatorTestSuite {
}