package com.codinggyan.streams;

import java.util.stream.Stream;

public class ConcatenateTwoStream {
    public static void main(String[] args) {

        // Stream 1: Stream of Strings
        Stream<String> stream1 = Stream.of("Java", "Python", "Go");

        // Stream 2: Stream of Strings
        Stream<String> stream2 = Stream.of("Kotlin", "Rust", "TypeScript");

        // Concatenate both streams
        Stream<String> combinedStream = Stream.concat(stream1, stream2);

        // Print all elements in combined stream
        combinedStream.forEach(System.out::println);

        // Another example: concatenating numbers
        Stream<Integer> intStream1 = Stream.of(1, 2, 3);
        Stream<Integer> intStream2 = Stream.of(4, 5, 6);

        Stream<Integer> combinedIntStream = Stream.concat(intStream1, intStream2);

        System.out.println("\nConcatenated Integer Stream:");
        combinedIntStream.forEach(System.out::println);
    }
}
