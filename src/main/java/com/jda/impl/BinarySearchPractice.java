package com.jda.impl;

public class BinarySearchPractice {

    public static void main (String... args) {

        int[] src = { 2, 6, 9, 13, 22, 30};
        int low = 0;
        int high = src.length - 1;
        int find = 9;
        int mid = 0;
        boolean found = false;

        while (high >= low) {
//        while (low <= high) {
            mid = (low + high) / 2;

            if (src[mid] == find) {
                found = true;
                System.out.println("Found at index " + mid);
                break;
            } else if (src[mid] > find) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Found " + found);

    }
}
