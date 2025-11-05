package com.codinggyan.functionalinterfaces.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // 1️⃣ Basic Consumer example
        Consumer<String> printName = name -> System.out.println("Hello, " + name + "!");
        printName.accept("Sumit");
        printName.accept("Ravi");

        // 2️⃣ Consumer with List.forEach()
        List<String> names = Arrays.asList("Sumit", "Ravi", "Amit", "Ankit");

        System.out.println("\nPrinting all names:");
        names.forEach(printName);

        // 3️⃣ Consumer chaining using andThen()
        Consumer<String> upperCaseConsumer = name -> System.out.println("Uppercase: " + name.toUpperCase());
        Consumer<String> lowerCaseConsumer = name -> System.out.println("Lowercase: " + name.toLowerCase());

        System.out.println("\nChained Consumers:");
        Consumer<String> chained = upperCaseConsumer.andThen(lowerCaseConsumer);
        names.forEach(chained);

        // 4️⃣ Consumer with custom object
        List<Employee> employees = Arrays.asList(
                new Employee("Sumit", 50000),
                new Employee("Ravi", 60000),
                new Employee("Amit", 55000)
        );

        System.out.println("\nEmployee details:");
        Consumer<Employee> printEmployee = e -> System.out.println(e.getName() + " earns ₹" + e.getSalary());
        employees.forEach(printEmployee);

        // 5️⃣ Consumer with conditional logic
        System.out.println("\nEmployees with salary > 55000:");
        Consumer<Employee> highEarnerConsumer = e -> {
            if (e.getSalary() > 55000) {
                System.out.println(e.getName() + " is a high earner!");
            }
        };
        employees.forEach(highEarnerConsumer);


    }
}
