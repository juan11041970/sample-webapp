package com.jda;

import com.jda.bo.JavaPerson;

import java.util.Arrays;

public class PersonComparable implements Comparable<PersonComparable> {

    private String lastName;
    private int age;

    public PersonComparable(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(PersonComparable other) {
        return this.age - other.age;  //ascending
//        return other.age - this.age;
    }

    public static void main(String ... args) {
        PersonComparable[]  people = new PersonComparable[2];

        people[0] = new PersonComparable("Alvarado", 48);
        people[1] = new PersonComparable("Quinones", 50);

        Arrays.sort(people);

        System.out.println("Done " + people[0] + "--" + people[1]);
    }
}
