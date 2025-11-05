package com.codinggyan.functionalinterfaces.supplier;

public class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " earns ₹" + salary;
    }
}
