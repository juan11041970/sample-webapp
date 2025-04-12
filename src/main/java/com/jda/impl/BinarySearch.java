package com.jda.impl;

public class BinarySearch {

    public static void main(String[] args) {
        doBinarySearch();
//        int[] src = {1, 4, 6, 8, 9, 10};
//        int low = 0;
//        int high = src.length - 1;
//        int mid = 0;
//
//        int findWhich = 8;
//        boolean found = false;
//
//        while (low <= high) {
//            mid = (low + high) / 2;
//            if (src[mid] == findWhich) {
//                System.out.println("Found it at index " + mid);
//                found = true;
//                break;
//            } else if (src[mid] > findWhich) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        System.out.println(found + " at " + mid);
    }

    public static void doBinarySearch() {

        int[] src = {1, 4, 6, 8, 9, 10};
        int low = 0;
        int high = src.length - 1; // high has to be zero index
        int mid = 0;
//
        int findWhich = 10;
        boolean found = false;

        while (low <= high) {
            mid = (low + high) / 2;
            int valueAtMid = src[mid];

            if (valueAtMid == findWhich) {
                System.out.println("Found it at index "  + mid);
                found = true;
                break;
            } else if (valueAtMid > findWhich) {
                System.out.println(findWhich + " is to the left");
                high = mid - 1;
            } else if (valueAtMid < findWhich) {
                System.out.println(findWhich + " is to the right");
                low = mid + 1;
            }
        }
        System.out.println(found);
    }
}
