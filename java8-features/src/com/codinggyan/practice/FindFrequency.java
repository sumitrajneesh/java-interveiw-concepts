package com.codinggyan.practice;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindFrequency {
    public static void main(String[] args) {

        String inputString = "Java Concept of the Day";

        Map<Character, Long> charcountMap =
               inputString.chars().mapToObj( c -> (char) c)
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charcountMap);
    }
}
