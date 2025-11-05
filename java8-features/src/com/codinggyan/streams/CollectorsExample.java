package com.codinggyan.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        // Sample data
        List<String> names = Arrays.asList("Sumit", "Ravi", "Amit", "Sumit", "Ankit", "Ravi");

        // 1️⃣ Collect to List
        List<String> nameList = names.stream()
                .collect(Collectors.toList());

        System.out.println("List: " + nameList);

        // 2️⃣ Collect to Set (removes duplicates)
        Set<String> nameSet = names.stream()
                .collect(Collectors.toSet());
        System.out.println("Set: " + nameSet);

        // 3️⃣ Collect to Map (name -> length)
        Map<String, Integer> nameLengthMap = names.stream()
                .distinct()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println("Map (Name -> Length): "  + nameLengthMap);

        // 4️⃣ Join all names with a comma
        String joinedNames = names.stream()
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " +joinedNames);

        // 5️⃣ Group by name length
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " +groupedByLength );

        // 6️⃣ Count occurrences of each name
        Map<String, Long> nameCount = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        System.out.println("Name Count: " +nameCount);

        // 7️⃣ Partitioning: names with length > 4 and <= 4
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 4));
        System.out.println("Partitioned (length > 4): " +partitioned);
    }

}
