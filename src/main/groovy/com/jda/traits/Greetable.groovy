package com.jda.traits

trait Greetable {

    abstract String name()

    String greeting() {
        "Hello ${name()}!"
    }

}