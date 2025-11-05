package com.codinggyan.methodreferences;

import java.util.Arrays;
import java.util.List;

public class StaticMethodReference {

    // A simple utility class with a static method
    static class Utility {
        public static void print(String msg) {
            System.out.println("Static print: " + msg);
        }

        public static boolean isEven(Integer number) {
            return number % 2 == 0;
        }
    }

    public static void main(String[] args) {

        // Example 1️⃣ — Using static method reference for printing
        List<String> messages = Arrays.asList("Java", "8", "Static", "Method", "Reference");

        // Using Lambda
        messages.forEach(msg -> Utility.print(msg));

        System.out.println("--------------------------------");

        // Using Static Method Reference
        messages.forEach(Utility::print);  // ClassName::staticMethod

        /*
         * Utility::print refers to the static method print(String msg)
         * and matches Consumer<String> (takes one argument, returns void)
         */

        System.out.println("--------------------------------");

        // Example 2️⃣ — Using static method reference in Stream filter
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(Utility::isEven) // equivalent to n -> Utility.isEven(n)
                .forEach(System.out::println);
    }

}
