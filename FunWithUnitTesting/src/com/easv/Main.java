package com.easv;

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Add test:" + calc.add(20,10));
        System.out.println("Subtract test:" + calc.subtract(20,10));
        System.out.println("Multiply test:" + calc.multiply(20,10));
        System.out.println("Divide test:" + calc.divide(20,0));
    }
}
