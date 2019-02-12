package com.jda.impl;

public class StringTest {

    public static void main(String[] args) {

        String name = "Sam";

        modify(name);

        System.out.println("In main: " + name);

        isPalindrome("racceccar q");
    }

    private static void modify(String name) {
        name = "John";
        System.out.println("In modify: " + name);

    }

    private static boolean isPalindrome(String word) {

        int left = 0;
        int right = word.length() - 1;
        char[] chars = word.toCharArray();
        boolean isPalin = true;

        while (left < right) {
            if (chars[left] == chars[right]){
                left++;
                right--;
            }
            else {
                isPalin = false;
                break;
            }
        }
        System.out.println(isPalin);
        return isPalin;
    }
}
