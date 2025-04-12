package com.jda.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTest {

    public static void main(String[] args) {

        longestNonRepeatingSubstring("");
        String name = "Sam";
        System.out.println("In main: " + name + "--> " + name.hashCode());

//        isPalindrome("racceccar");
//        isPalindrome2("racceccar");
        isPalindrme("racceccar");
    }



    public static String longestNonRepeatingSubstring(String str) {
        int leftSideOfWindow = 0, rightSideOfWindow = 0;
        Map<Character, Integer> uniqueCharsSet = new HashMap<>();
        int len = 0;
        str = "abcbdef";
//        str = "bbbbb";
        StringBuilder stringBuilder = new StringBuilder();

        int maxLength = 0;
        Map<Character, Integer> visitedChars = new HashMap<>();

        for (int start = 0,  end = 0; start < str.length(); start++) {
            char currentChar = str.charAt(start);

            if (visitedChars.containsKey(currentChar) && visitedChars.get(currentChar) >= end) {
                end = visitedChars.get(str.charAt(start)) + 1;
            }
            maxLength = Math.max(maxLength, start - end + 1);
            visitedChars.put(currentChar, start);
        }
        System.out.println("maxLength: " +  maxLength);

        return "";
    }

    private static boolean isPalindrme(String word) {

        int left = 0;
        int right = word.length() - 1;
        final char[] chars = word.toCharArray();

        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    private static boolean isPalindrome2(String word) {

        int wordLength = word.length();
        StringBuilder strBuilder = new StringBuilder();
        char[] chars = word.toCharArray();

        for (int i = wordLength -1; i >=0; i--) {
            strBuilder.append(chars[i]);
        }

        System.out.println(strBuilder.toString());

        if(word.equals(strBuilder.toString())) {
            System.out.println(strBuilder.toString() + " is a palindrome");
        }

        return true;
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
