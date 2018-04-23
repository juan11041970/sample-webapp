package com.jda;

import com.jda.bo.JavaPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonCompare implements Comparator<JavaPerson> {


    public int compare(JavaPerson o1, JavaPerson o2) {
        return o1.getAge()  - o2.getAge();
    }

    public static void main(String[]  args) {

        List<JavaPerson> people = new ArrayList<JavaPerson>();

        people.add(new JavaPerson("juan", "Alvarado", 21));
        people.add(new JavaPerson("Jose", "Quinones", 40));
        people.add(new JavaPerson("juan", "Alvarado", 75));
        people.add(new JavaPerson("juan", "Alvarado", 69));
        people.add(new JavaPerson("juan", "Alvarado", 52));
        people.add(new JavaPerson("juan", "Alvarado", 35));

        Collections.sort(people, new PersonCompare());

        System.out.println("Done sorting");
    }
}
