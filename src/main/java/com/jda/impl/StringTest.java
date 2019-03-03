package com.jda.impl;

public class StringTest {

    public static void main(String[] args) {

        String name = "Sam";

        modify(name);

        System.out.println("In main: " + name + "--> " + name.hashCode());

        isPalindrome("racceccar");
        isPalindrome2("racceccar");
    }

    private static void modify(String name) {
        name = "John";
        System.out.println("In modify: " + name + "-->  " + name.hashCode());

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
