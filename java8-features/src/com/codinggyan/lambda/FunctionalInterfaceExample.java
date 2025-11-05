package com.codinggyan.lambda;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Demonstrates:
 *  1. Custom Functional Interface
 *  2. Built-in Functional Interfaces:
 *     - Predicate
 *     - Function
 *     - Consumer
 *     - Supplier
 */
public class FunctionalInterfaceExample {

    // 1️⃣ Custom Functional Interface
    @FunctionalInterface
    interface Calculator {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println(" Function Interface");
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("Addition: " + add.operate(10, 20));
        System.out.println("Multiplication " + multiply.operate(5,4));

        System.out.println("\n=== Build in Function Interfaces");

        // 2️⃣ Predicate: test condition
        Predicate<String> startWithJ = s -> s.startsWith("J");
        System.out.println("Start with J? " + startWithJ.test("Java"));

        // 3️⃣ Function: takes one input, returns a result
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Lambda' : " + stringLength.apply("Lambda"));

        // 4️⃣ Consumer: takes input, no return
        Consumer<String> printer = msg -> System.out.println("Message: " + msg);
        printer.accept("Hello Functional Interface");

        // 5️⃣ Supplier: no input, returns value
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
    }
}
