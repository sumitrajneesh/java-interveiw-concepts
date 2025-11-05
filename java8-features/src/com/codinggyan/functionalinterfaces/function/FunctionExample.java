package com.codinggyan.functionalinterfaces.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {

    public static void main(String[] args) {
        // 1️⃣ Basic Function Example
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));
        System.out.println("Square of 10: " + square.apply(10));

        // 2️⃣ Function with String
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("\nLength of 'Sumit': " + stringLength.apply("Sumit"));

        // 3️⃣ Function chaining: andThen() and compose()
        Function<Integer, Integer> doubleIt = n -> n * 2;
        Function<Integer, Integer> addTen = n -> n + 10;

        System.out.println("\nFunction chaining:");
        // first double, then add 10
        System.out.println("andThen: " + doubleIt.andThen(addTen).apply(5)); // (5*2)+10 = 20
        // first add 10, then double
        System.out.println("compose: " + doubleIt.compose(addTen).apply(5)); // (5+10)*2 = 30

        // 4️⃣ Function with List transformation using Stream.map()
        List<String> names = Arrays.asList("Sumit", "Ravi", "Amit", "Ankit");
        Function<String, String> toUpperCase = name -> name.toUpperCase();

        List<String> upperNames = names.stream()
                .map(toUpperCase)
                .collect(Collectors.toList());
        System.out.println("\nUppercase Names: " + upperNames);

        // 5️⃣ Function with custom object transformation
        List<Employee> employees = Arrays.asList(
                new Employee("Sumit", 50000),
                new Employee("Ravi", 40000),
                new Employee("Amit", 60000)
        );

        // Function: Employee -> Salary Hike (new salary)
        Function<Employee, Double> salaryHike = emp -> emp.getSalary() * 1.10; // 10% hike

        System.out.println("\nEmployee Salary Hike:");
        employees.forEach(e ->
                System.out.println(e.getName() + " new salary: ₹" + salaryHike.apply(e))
        );

        // 6️⃣ Function Identity (returns input as it is)
        Function<String, String> identity = Function.identity();
        System.out.println("\nIdentity Function: " + identity.apply("No change in value"));
    }
}
