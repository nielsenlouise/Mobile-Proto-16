package com.example;

import java.util.Random;

/**
 * Created by lnielsen on 9/11/16.
 */
public class Cat extends Animal {

    public Cat(String name, String color){
        super(4, name, color, "cat", new Random().nextInt(25));
    }

    public void grow() {
        setWeight(getWeight()*3);
    }
}
