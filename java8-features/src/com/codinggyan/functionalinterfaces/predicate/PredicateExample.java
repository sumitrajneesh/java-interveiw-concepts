package com.codinggyan.functionalinterfaces.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {

        // 1️⃣ Basic Predicate Example
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 11 even ? " + isEven.test(11));

        // 2️⃣ Predicate with String
        Predicate<String> startsWithS = name -> name.startsWith("S");
        System.out.println("\nDoes 'Sumit' start with 'S' ? " + startsWithS.test("Sumit"));
        System.out.println("Does 'Amit' start with 'S' ? " + startsWithS.test("Amit"));

        // 3️⃣ Predicate with filter in Stream
        List<String> names = Arrays.asList("Sumit", "Ravi", "Amit", "Ankit", "Saurabh");
        List<String> sNames = names.stream()
                .filter(startsWithS)
                .collect(Collectors.toList());

        System.out.println("\nNames starting with S: " + sNames);

        // 4️⃣ Predicate chaining: and(), or(), negate()
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isMultipleOfFive = n -> n % 5 == 0;

        System.out.println("\nPredicate chaining:");
        System.out.println("Is 10 positive and multiple of 5? " + isPositive.and(isMultipleOfFive).test(10));
        System.out.println("Is -5 positive or multiple of 5? " + isPositive.or(isMultipleOfFive).test(-5));
        System.out.println("Is 0 NOT positive? " + isPositive.negate().test(0));

        // 5️⃣ Predicate with custom object
        List<Employee> employees = Arrays.asList(
                new Employee("Sumit", 50000),
                new Employee("Ravi", 40000),
                new Employee("Amit", 60000),
                new Employee("Ankit", 30000)
        );

        Predicate<Employee> highEarner = emp -> emp.getSalary() > 45000;

        List<Employee> filteredEmployees = employees.stream()
                .filter(highEarner)
                .collect(Collectors.toList());

        System.out.println("\nEmployees earning > 45000:");
        filteredEmployees.forEach(System.out::println);
    }
}
