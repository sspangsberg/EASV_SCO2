package com.easv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Class Unit Tests")
class CalculatorTest {

    @Test
    void add() {

        // Arrange
        Calculator calc = new Calculator();

        // Act
        int actualValue = calc.add(20,10);
        int expectedValue = 30;

        // Assert
        Assertions.assertEquals(actualValue, expectedValue);
    }

    @DisplayName("Subtract Test")
    @Test
    void subtract() {
        Assertions.fail("Not implemented yet");
    }

    @DisplayName("Multiply Test")
    @Test
    void multiply() {
        Assertions.fail("Not implemented yet");
    }


    @DisplayName("Test Divide Method w valid data")
    @Test
    void testValidDivide() {

        // Arrange
        Calculator calc = new Calculator();

        // Act
        int actualValue = calc.divide(20,10);
        int expectedValue = 2;

        // Assert
        Assertions.assertEquals(actualValue, expectedValue);
    }


    @DisplayName("Test Divide Method w invalid data")
    @Test
    void testInvalidDivide() {

        // Arrange
        Calculator calc = new Calculator();

        // Act + assert
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10,0);
        });

        // Extra Assert
        String expected = "Divide by 0.";
        String actual = ex.getMessage();

        Assertions.assertEquals(expected, actual);
    }


}