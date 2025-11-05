package com.codinggyan.lambda;

import java.util.function.Consumer;

public class VariableScopeExample {

    // 🔹 Instance variable
    private int instanceVar = 100;

    // 🔹 Static variable
    private static int staticVar = 200;


    public void demonstrateScope() {
        // 🔹 Local variable
        int localVar = 300;

        System.out.println("Inside demostrateScope()");
        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " +staticVar);
        System.out.println("Local Variable: " +localVar);

        // 🔹 Lambda variable scope
        // Lambdas can access local variables — but only if they are *effectively final*
        Consumer<Integer> lambda = (x) -> {
            System.out.println("\nInside Lambda:");
            System.out.println("Parameter x: " + x);
            System.out.println("Accessing instanceVar: " + instanceVar);
            System.out.println("Accessing staticVar: " + staticVar);
            System.out.println("Accessing localVar (effectively final): " + localVar);
        };

        lambda.accept(400);
        // Uncommenting this line would cause a compile error:
        // localVar = 350; // ❌ localVar is used in lambda, so it must be effectively final
    }

    public static void main(String[] args) {
        VariableScopeExample example = new VariableScopeExample();
        example.demonstrateScope();

        System.out.println("\nAccessing from static context:");
        System.out.println("Static Variable: " + VariableScopeExample.staticVar);
    }


}
