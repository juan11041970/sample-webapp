package com.jda.impl

import com.jda.traits.FlyingAbility

class Eagle implements  FlyingAbility{

    static void main(String... args) {

        def bird = new Eagle()
        assert bird.fly() == "I'm flying"
    }

}
