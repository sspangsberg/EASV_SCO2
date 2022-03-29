package com.easv;

public class Calculator {

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) throws IllegalArgumentException {
        if (number2 == 0)
            throw new IllegalArgumentException("Divide by 0");

        return number1 / number2;
    }




}
