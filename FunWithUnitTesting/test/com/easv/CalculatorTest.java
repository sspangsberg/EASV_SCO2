package com.easv;

// JUnit imports
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


@DisplayName("Calculator Class Unit Tests")
class CalculatorTest {

    @Test
    void add() {

        // Arrange
        Calculator calc = new Calculator();

        // Act
        int actual = calc.add(20,10);
        int expected = 30;

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Subtract Test")
    @Test
    void subtract() {
        Assertions.fail("Not implemented yet");
    }

    @DisplayName("Multiply Test")
    @Disabled
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
        int actual = calc.divide(20,10);
        int expected = 2;

        // Assert
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("Test Divide Method w invalid data")
    @Test
    void testInvalidDivide() {

        // Arrange
        Calculator calc = new Calculator();

        // Act + assert
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calc.divide(10, 0);
            }
        });

        // Extra Assert
        String expected = "Divide by 0";
        String actual = ex.getMessage();

        Assertions.assertEquals(expected, actual);
    }
}