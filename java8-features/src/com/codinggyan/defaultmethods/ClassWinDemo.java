package com.codinggyan.defaultmethods;

interface X {
    default void display() { System.out.println("Interface X"); }
}

class Y {
    public void display() { System.out.println("Class Y"); }
}

class Z extends Y implements X { }
public class ClassWinDemo {
    public static void main(String[] args) {
        new Z().display(); // ✅ Output: "Class Y"
    }
}
