package com.codinggyan.streams.filtermap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapExample {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Sumit", 90000, "DevOps"),
                new Employee(102, "Akhila", 120000, "AI"),
                new Employee(103, "Ravi", 70000, "Support"),
                new Employee(104, "John", 150000, "Engineering"),
                new Employee(105, "Alice", 80000, "QA")
        );

        // 1️⃣ Filter employees with salary > 80000
        System.out.println("--- Filter: Salary > 80000 ---");
        employees.stream()
                .filter(e -> e.getSalary() > 80000)
                .forEach(System.out::println);

        // 2️⃣ Map employee names to uppercase
        System.out.println("\n--- Map: Names to Uppercase ---");
        employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 3️⃣ Combined filter + map + collect
        System.out.println("\n--- Filter + Map + Collect Example ---");
        List<String> highPaidNames = employees.stream()
                .filter(e -> e.getSalary() > 90000)    // keep only high-paid employees
                .map(Employee::getName)                // get names
                .map(String::toUpperCase)              // transform to uppercase
                .collect(Collectors.toList());         // collect results to list
        System.out.println(highPaidNames);

        // 4️⃣ Filter by department and increase salary (map transformation)
        System.out.println("\n--- Filter DevOps Department & Increase Salary by 10% ---");
        List<Employee> updatedList = employees.stream()
                .filter(e -> e.getDepartment().equals("DevOps"))
                .map(e -> new Employee(
                        e.getId(),
                        e.getName(),
                        e.getSalary() * 1.10, // increase by 10%
                        e.getDepartment()))
                .collect(Collectors.toList());

        updatedList.forEach(System.out::println);
    }
}
