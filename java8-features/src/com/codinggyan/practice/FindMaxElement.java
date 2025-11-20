package com.codinggyan.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaxElement {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(10, 15,8,49, 25, 98,98,32,15);
//        int max = number.stream().max(Integer::compare).get();

//        int max = number.stream().max((a,b) -> a.compareTo(b)).get();

        int max = number.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);

    }
}
