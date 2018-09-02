package com.jda.fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitBiteTest {

    public static void main(String[] args) {

        Map<FruitBiteStrategy, FruitBiteStrategy> fruits = new HashMap<FruitBiteStrategy, FruitBiteStrategy>();

        FruitBiteStrategy apple = new AppleBiteStrategyImpl();
        fruits.put(apple, apple);

        FruitBiteStrategy strawberry = new StrawberryBiteStrategyImpl();
        fruits.put(strawberry, strawberry);

        FruitBiteStrategy banana = new BananaBiteStrategyImpl();
        fruits.put(banana, banana);

        FruitBiteStrategy biting = fruits.get(apple);
        biting.bite();

        biting = fruits.get(strawberry);
        biting.bite();

        biting = fruits.get(banana);
        biting.bite();

        System.out.println("Done!!!");
    }
}
