package com.jda.impl;

public class IsPalindrome {

    public static void main(String[] args) {
        String src = "racecarr";

        int low = 0;
        int high = src.length() - 1;
        boolean isPalindrome = true;

        while (high >= low) {

            if (src.charAt(high) != src.charAt(low)) {
                System.out.println("Not a palindrome");
                isPalindrome = false;
                break;
            } else {
                low++;
                high--;
            }
        }

        System.out.println(isPalindrome + " is a palindrome");
    }
}
