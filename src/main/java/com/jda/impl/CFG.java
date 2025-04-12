package com.jda.impl;

// Java Program to demonstrate Brute Force Method to check if a number is prime
class GFG {
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Driver Program
    public static void main(String args[])
    {
        int chr = 'b';

        if (isPrime(13)) {
            System.out.println(" true");
        } else {
            System.out.println(" false");
    }

//        if (isPrime(15))
//            System.out.println(" true");
//        else
//            System.out.println(" false");
    }
}
