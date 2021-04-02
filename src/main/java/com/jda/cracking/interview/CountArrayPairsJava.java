package com.jda.cracking.interview;

public class CountArrayPairsJava {

    public static void main(String[] args) {
        CountArrayPairsJava countArrayPairs = new CountArrayPairsJava();
//        countArrayPairs.count()
        countArrayPairs.count2();
    }

    static void count2() {
        int diff = 3;
//        int[] numbers = {5, 2};
        int[] numbers = {5, 3, 9, 7, 21, 23, 0, 2};
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currI = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {

            }
        }

    }
}
