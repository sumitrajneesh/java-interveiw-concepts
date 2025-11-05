package com.codinggyan.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {

        // 1️⃣ Stream Creation
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // a) From a Collection
        Stream<String> stream1 = names.stream();

        // b) From an Array
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});

        // c) Using Stream.of()
        Stream<String> stream3 = Stream.of("Java", "Streams", "Are", "Powerful");

        // ✅ Streams are *not reusable* once consumed
        // stream1.forEach(System.out::println); // consumes the stream
        // stream1.forEach(System.out::println); // ERROR: IllegalStateException

        // 2️⃣ Intermediate Operations (transformations)
        System.out.println("\n--- Filter + Map Example ---");
        names.stream()
                .filter(name -> name.length() > 3)     // filter longer names
                .map(String::toUpperCase)              // convert to uppercase
                .forEach(System.out::println);         // terminal operation

        // 3️⃣ Terminal Operations
        System.out.println("\n--- Count Example ---");
        long count = names.stream()
                .filter(n -> n.startsWith("A"))
                .count();
        System.out.println("Names starting with A: " + count);

        // 4️⃣ Collecting Results
        System.out.println("\n--- Collect Example ---");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList(); // Java 16+, else use Collectors.toList()
        System.out.println(upperCaseNames);

        // 5️⃣ Stream Pipeline Example (Single Flow)
        System.out.println("\n--- Complete Stream Pipeline ---");
        Arrays.asList(3, 6, 2, 8, 1, 9)
                .stream()
                .filter(n -> n % 2 == 0)     // keep even numbers
                .sorted()                    // sort them
                .map(n -> n * n)             // square each
                .forEach(System.out::println);
    }
}
