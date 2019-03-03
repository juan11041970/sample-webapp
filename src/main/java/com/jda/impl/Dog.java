package com.jda.impl;

import com.jda.interfaces.Animal;

public class Dog implements Animal {
    @Override
    public String getAnimalName() {
        return "DOG";
    }
}
