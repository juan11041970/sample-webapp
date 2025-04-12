package com.jda.impl;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
                ans += mp.get(s.charAt(i + 1)) - mp.get(s.charAt(i));
                i++;
            } else {
                ans += mp.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static int lengthOfLongestSubstring(String str) { //abcbdef
        int maxLength = 0;
        Map<Character, Integer> visitedChars = new HashMap<>();
        str = "abcabcbbartup";

        for (int i = 0,  leftWindow = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            boolean containsCurrChar = visitedChars.containsKey(currentChar);
            String subStrSoFar = str.substring(leftWindow, i);

            if (visitedChars.containsKey(currentChar)  //Map has current char (repeat character)
                    && visitedChars.get(currentChar) >= leftWindow)
            { // check to make sure repeated character is within current substring
                leftWindow = visitedChars.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, i - leftWindow + 1);
            visitedChars.put(currentChar, i);
        }

        System.out.println("maxLength::: " + maxLength);
        return maxLength;
    }

    public static void main(String[] args) {

        romanToInt("III");
        romanToInt("LVIII");
        romanToInt("MCMXCIV");

        System.out.println(lengthOfLongestSubstring("abcbdef"));
//        System.out.println(lengthOfLongestSubstring("geeksforgeeks"));

        Solution sol = new Solution();
//        String result = sol.longestNonRepeatingSubstring("abcbdef");
//        String result = sol.longestNonRepeatingSubstring("geeksforgeeks");
////
////        System.out.println(result);bdef");
//
//        System.out.println(result);


        String bin1 = "11";  // 10 in decimal
        String bin2 = "1";  // 13 in decimal

        // Convert binary strings to integers
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);

        // Add the numbers
        int sum = num1 + num2;

        // Convert the sum back to a binary string
        String binarySum = Integer.toBinaryString(sum);

        System.out.println(binarySum);

    }
}