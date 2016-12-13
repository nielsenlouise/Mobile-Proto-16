package com.example;

import java.util.Random;

/**
 * Created by lnielsen on 9/11/16.
 */
public class Dog extends Animal {

    public Dog(String name, String color){
        super(4, name, color, "dog", new Random().nextInt(25));
    }

    public void grow() {
        setWeight(getWeight()*1.5);
    }
}
