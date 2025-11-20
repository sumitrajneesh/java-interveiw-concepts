package com.codinggyan.practice;

import java.util.Arrays;
import java.util.List;

public class FindEvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,2,12,34,20);
        list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
    }

}
