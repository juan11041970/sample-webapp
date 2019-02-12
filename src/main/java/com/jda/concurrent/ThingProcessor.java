package com.jda.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThingProcessor implements Runnable {

    private String thing;

    public ThingProcessor(String theThing) {
        this.thing = theThing;
    }


    @Override
    public void run() {

        System.out.println("The thing is: " + this.thing);

    }
}
