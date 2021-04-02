package com.jda.impl;

import java.util.HashMap;
import java.util.Map;

public class ArrayTwoSum {

    public static void main(String[] args) {

        int[] numbers = { 2, 7, 11, 15, 17, 25 };
//        findIndices(numbers, 18);
        //findIdxs(numbers, 42);
        setDebugFlags(4 | 8);
    }

    public static void findIdxs(int[] numbers, int targetNum) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = targetNum - numbers[i];
            if (numsMap.containsKey(delta)) {
                System.out.println("Indices: " + numsMap.get(delta) + " - " + i);
            } else {
                numsMap.put(numbers[i], i);
            }

        }
    }

    public static void findIndices(int[] numbers, int targetNum) {

        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
           int delta = targetNum - numbers[i];
           if (visitedNumbers.containsKey(delta)) {
                System.out.println(i + " - " + visitedNumbers.get(delta));
           } else {
               visitedNumbers.put(numbers[i], i);
           }
        }
    }

    public static void setDebugFlags(long flags) {
        System.out.println("Flags: " + flags);
    }
}
