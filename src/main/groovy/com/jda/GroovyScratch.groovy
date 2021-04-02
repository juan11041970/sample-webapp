package com.jda

import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC
import groovy.swing.SwingBuilder
import javax.swing.ImageIcon

class GroovyScratch {

    static void main(String[] args) {
        println "Starting..."
        println (isReverseSameString("racecar"))

//        int[] nums = [2, 4, 5, 3, 20, 22]
        int[] nums = [2, 4]
        int diff = 2

         println "Number of pairs: " + arraySumPairs(nums, diff)
    }

    static int arraySumPairs(int[] nums, int diff) {

        Map<Integer, Integer> mappings = [:]

        for (int i = 0; i < nums.length; i++) {
            def currentNum = nums[i] as Integer
            mappings << [(currentNum) : currentNum]
        }
        println mappings

        def numberOfPairs = 0
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i]
            println "Processing current number: ${currentNum}"
            //check sum
            int sum = currentNum + diff
            println "Sum is: ${sum}"
            if (mappings.get(sum) == sum) {
                //found a matching pair
                println "Increasing pairs in SUM for current number: ${currentNum}"
                numberOfPairs++
            }

            //check diff
            int minus = currentNum - diff
            println "Minus is: ${minus}"
            if (mappings.get(minus) == minus) {
                println "Increasing pairs in MINUS for current number: ${currentNum}"
                numberOfPairs++
            }
        }
        return numberOfPairs
    }

    static boolean isReverseSameString(String input) {

        def chars = input.toCharArray()
        def left = 0, right = chars.length - 1

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++
                right--
            }
        }
        return true
    }
}

