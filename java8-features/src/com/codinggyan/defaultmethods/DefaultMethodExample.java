package com.codinggyan.defaultmethods;

// 🔹 Java 8 introduced default methods in interfaces
interface Vehicle {
    // Abstract method (must be implemented by subclass)
    void start();

    // Default method (has a body — optional to override)
    default void stop() {
        System.out.println("Vehicle is stopped");
    }

    // Static method in interface (introduced in Java 8)
    static void service() {
        System.out.println("Vehicle service is schedule");
    }
}

// 🔹 Implementing class
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

// 🔹 Another implementation that uses default method as-is
class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike started");
    }

    // Not overriding stop() — uses default version
}


public class DefaultMethodExample {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();
        car.start();

        bike.start();
        bike.stop(); // uses default stop() from interface

        // Static method called using interface name
        Vehicle.service();
    }
}
