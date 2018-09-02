package com.jda.impl

class GreetableImpl implements com.jda.traits.Greetable {

    String name() {
        'John'
    }

    static void main(String ... args) {

        def g = new GreetableImpl()
        assert g.greeting() == 'Hello John!'
    }
}
