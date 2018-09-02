package com.jda

class PersonConstructor {

    String name
    Integer age

    PersonConstructor(name, age) {
        this.name = name
        this.age = age
    }

    static void main (String ... args) {

        def person1 = new PersonConstructor('Juan', 28)
        def person2 = ['Juan', 28] as PersonConstructor

        println person2.age
        println person2.name
   }
}
