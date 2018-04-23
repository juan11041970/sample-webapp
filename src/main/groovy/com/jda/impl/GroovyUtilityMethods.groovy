package com.jda.impl

import com.jda.interfaces.UtilityMethods

class GroovyUtilityMethods implements UtilityMethods {

    static void main(String[] args) {

        GroovyUtilityMethods groovyUtilityMethods = new GroovyUtilityMethods()

        int[] nums = [2, 5, 9]
        def results = groovyUtilityMethods.getPositives(nums)

        println results
    }

    int[] getPositives(int ... values) {

        def results = []

        values.each { num ->
            if (num > 0) results.add(num)
        }

        int[] answer = new int[results.size()]

        for (i in 0..results.size() - 1) {
            answer[i] = results.get(i)
        }

        return answer
    }

    boolean isPrime(int x) {
        return false
    }

    boolean isPalindrome(String s) {
        return false
    }
}
