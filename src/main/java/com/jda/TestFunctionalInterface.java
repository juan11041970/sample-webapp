package com.jda;

import com.jda.interfaces.Square;

import java.util.function.Predicate;

public class TestFunctionalInterface {

    public static void main(String ... args) {

        new Thread( () -> {
            System.out.println("Thread started"); }).start();

        Square sq = (int s) -> s * s;

        int ans = sq.calculate(10);
        System.out.println("The answer is: " + ans);

//        String a = "a";
        String b = "b";

        Predicate p = (a) -> a == b;
        boolean test = p.test("a");
        System.out.println(test);

        Integer age = 48;
        p = (paramAge) -> {
            return ((Integer) paramAge).intValue() == new Integer(48).intValue();
        };

        test = p.test(age);
        System.out.println(test);
    }
}
