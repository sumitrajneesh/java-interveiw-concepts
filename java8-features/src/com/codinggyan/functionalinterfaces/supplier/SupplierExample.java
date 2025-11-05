package com.codinggyan.functionalinterfaces.supplier;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        // 1️⃣ Basic Supplier Example
        Supplier<String> messageSupplier = () -> "Hello from Supplier!";
        System.out.println(messageSupplier.get());

        // 2️⃣ Supplier for current date & time
        Supplier<LocalDateTime> dateTimeSupplier = () -> LocalDateTime.now();
        System.out.println("Current time: " + dateTimeSupplier.get());

        // 3️⃣ Supplier for random number
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("Random Number: " + randomSupplier.get());

        // 4️⃣ Supplier with lazy initialization
        Supplier<Double> expensiveComputation = () -> {
            System.out.println("performing expensive computation...");
            return Math.sqrt(new Random().nextInt(1000));
        };

        System.out.println("\nLazy initialization example:");
        System.out.println("Computation Result: " + expensiveComputation.get());

        // 5️⃣ Supplier returning a custom object
        Supplier<Employee> employeeSupplier = () -> new Employee("sumit", 5000);
        Employee emp = employeeSupplier.get();
        System.out.println("\nEmployee created by Supplier: " + emp);

        // 6️⃣ Supplier as fallback (useful in Optional or configuration)
        String value = null;
        Supplier<String> defaultSupplier = () -> "Default Value";
        String result = (value != null) ? value : defaultSupplier.get();
        System.out.println("\nFallback Value: " + result);
    }


}
