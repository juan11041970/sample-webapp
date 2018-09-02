package com.jda.application;

import com.jda.bo.JavaPerson;

import java.util.Arrays;
import java.util.List;

public class MyApplication  {

    public MyApplication() {

    }

    public static void main(String... args) {
        JavaPerson person = new JavaPerson();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

       // list.forEach(MyApplication::print);

        System.out.println("Initializing..." + Foo.class);
        Foo.sayHello();
    }

    public static void print(final int number) {

        System.out.println("I am printing: " + number);
    }
}

class Foo {
    static {
        System.out.println("Initializing Foo");
    }

    public static void sayHello() {
        System.out.println("Say hello");
    }
}
