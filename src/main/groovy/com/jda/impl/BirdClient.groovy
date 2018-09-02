package com.jda.impl

class BirdClient {

    static void  main(String... args) {

        //def birds = [new Penguin(), new Duck(), new BrownPelican()]

        def bird = new Duck()
        println "---I am a duck"
        bird.fly()
        bird.swim()

        bird = new Penguin()
        println "---I am a penguin"
        bird.swim()

        bird = new BrownPelican()
        println "---I am a brown pelican"
        bird.swim()
        bird.fly()

        bird = new Eagle()
        println "---I am an eagle pelican"
        bird.fly()

    }
}
