package com.codinggyan.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {

        // 1️⃣ Sequential Stream
        System.out.println("--- Sequential Stream ---");
        IntStream range1 = IntStream.rangeClosed(1, 10);
        range1.forEach(n -> System.out.println(Thread.currentThread().getName() + " : " + n));

        System.out.println("\n--- Parallel Stream ---");
        IntStream range2 = IntStream.rangeClosed(1, 10);
        range2.parallel().forEach(n -> System.out.println(Thread.currentThread().getName() + " : " + n));

        /*
         * ✅ Difference:
         *  - sequential() executes one element at a time in main thread
         *  - parallel() splits the work across multiple threads (ForkJoinPool)
         */

        // 2️⃣ Example with List
        List<String> names = Arrays.asList("Sumit", "Akhila", "Ravi", "John", "Alice", "Bob");

        System.out.println("\n--- Sequential Processing ---");
        names.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(Thread.currentThread().getName() + " processed " + name));

        System.out.println("\n--- Parallel Processing ---");
        names.parallelStream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(Thread.currentThread().getName() + " processed " + name));

        /*
         * You’ll notice multiple threads (ForkJoinPool threads) are working concurrently.
         */

        // 3️⃣ Measuring Performance Difference
        System.out.println("\n--- Performance Comparison ---");

        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000)
                .map(ParallelStreamExample::compute)
                .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential Time: " + sequentialTime + " ms");

        long startTime2 = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .map(ParallelStreamExample::compute)
                .sum();
        long parallelTime = System.currentTimeMillis() - startTime2;
        System.out.println("Parallel Time: " + parallelTime + " ms");
    }

    // Simulate heavy computation
    private static int compute(int n) {
        try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        return n * 2;
    }
}
