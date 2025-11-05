package com.codinggyan.streams.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExample {

    public static void main(String[] args) {

        // 1️⃣ Sorting simple strings
        List<String> names = Arrays.asList("Sumit", "Akhila", "Ravi", "John", "Alice");

        System.out.println("--- Natural Sorting (Ascending) ---");
        names.stream()
                .sorted() // natural order (alphabetical)
                .forEach(System.out::println);

        System.out.println("\n--- Reverse Sorting (Descending) ---");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // 2️⃣ Sorting numbers
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        System.out.println("\n--- Numbers Sorted Ascending ---");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n--- Numbers Sorted Descending ---");
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // 3️⃣ Sorting list of custom objects
        List<Employee> employees = Arrays.asList(
                new Employee(103, "Sumit", 90000),
                new Employee(101, "Akhila", 95000),
                new Employee(104, "Ravi", 87000),
                new Employee(102, "John", 99000)
        );

        System.out.println("\n--- Sort Employees by ID (Ascending) ---");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getId))
                .forEach(System.out::println);

        System.out.println("\n--- Sort Employees by Name (Alphabetically) ---");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("\n--- Sort Employees by Salary (Descending) ---");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // 4️⃣ Collecting sorted results into a list
        System.out.println("\n--- Collecting Sorted List by Salary ---");
        List<Employee> sortedList = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
}
