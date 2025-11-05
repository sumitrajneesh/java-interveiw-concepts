package com.codinggyan.defaultmethods;

interface Parent {
    default void message() { System.out.println("Parent Interface"); }
}

interface Child extends Parent {
    default void message() { System.out.println("Child Interface"); }
}

class Demo implements Child { }

public class SubInterfaceWinDemo {
    public static void main(String[] args) {
        new Demo().message(); // ✅ Output: "Child Interface"
    }
}
