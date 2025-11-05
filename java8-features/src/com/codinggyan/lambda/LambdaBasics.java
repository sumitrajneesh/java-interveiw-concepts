package com.codinggyan.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Demonstrates basic Java 8 Lambda features:
 *  - Without and with parameters
 *  - With return value
 *  - Using functional interfaces like Predicate, Consumer, Function
 *  - With collections
 **/
public class LambdaBasics {
    public static void main(String[] args) {

        // 1️⃣ Simple Lambda Expression (No parameter)
        Runnable greet = () -> System.out.println("Hello from Lambda!");
        greet.run();

        // 2️⃣ Lambda with one parameter
        Consumer<String> printer = (msg) -> System.out.println("Message: " + msg);
        printer.accept("Learning Lambda expressions !");


        // 3️⃣ Lambda with two parameters and a return value
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(10, 20));

        // 4️⃣ Predicate Example (returns boolean)
        Predicate<Integer> isEven = n -> n%2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        // 5️⃣ Function Example (transforming data)
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Length of 'Lambda' : " + strLength.apply("Lambda"));

        // 6️⃣ Using Lambda in Collections - Sorting
        List<String> names = Arrays.asList("sumit", "amit", "Raj", "vikas");
        names.sort((a,b) -> a.compareTo(b));
        System.out.println("Sorted Names: " + names);

        names.forEach(name -> System.out.println("Name: " +name));


    }

}
