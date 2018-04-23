package com.jda.bo

class GroovyProduct {

    int id
    String name
    double price

    GroovyProduct(Map args) {

        args.each {
            k, v -> setProperty(k.toLowerCase(), v)
        }
    }
}
