package com.codinggyan.defaultmethods;

// 🔹 Interface A with a default method
interface A {
    default void show() {
        System.out.println("Inside A.show()");
    }
}

// 🔹 Interface B with a default method having the same name
interface B {
    default void show() {
        System.out.println("Inside B.show()");
    }
}

// 🔹 Class C implements both A and B — conflict arises here
class C implements A, B {

    // ❌ Ambiguity: both A and B define show()
    // ✅ Must override it to resolve the conflict
    @Override
    public void show() {
        System.out.println("Inside C.show() resolving conflict");

        // You can still call specific interface methods:
        A.super.show(); // Calls A's version
        B.super.show(); // Calls B's version
    }
}

public class MultipleInheritanceExample {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
