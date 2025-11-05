package com.codinggyan.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InstanceMethodReference {
    // A simple utility class
    static class Printer {
        public void printMessage(String message) {
            System.out.println("Printing: " + message);
        }
    }

    public static void main(String[] args) {

        List<String> messages = Arrays.asList("Hello", "Java", "8", "Method", "Reference");

        // ✅ Using Lambda
        Consumer<String> lambdaPrinter = msg -> System.out.println("Lambda: " + msg);
        messages.forEach(lambdaPrinter);

        System.out.println("--------------------------------");

        // ✅ Using instance method reference
        Printer printer = new Printer();
        Consumer<String> methodRefPrinter = printer::printMessage; // instance::method
        messages.forEach(methodRefPrinter);

        /*
         * Explanation:
         * printer::printMessage refers to the instance method of the specific object `printer`.
         * It matches the Consumer<T> functional interface (takes one argument, returns void).
         *
         * Internally, for each message, Java calls printer.printMessage(message).
         */
    }
}
