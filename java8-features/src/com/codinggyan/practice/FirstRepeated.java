package com.codinggyan.practice;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeated {

    public static void main(String[] args) {
        String input = "Java Articles are Awesome";

        Set<Character> seenCharacters = new HashSet<>();

        Character res = input.chars().mapToObj( c -> (char) c)
                .filter(c -> !seenCharacters.add(c)).findFirst().orElse(null);
        System.out.println(res);
    }
}
