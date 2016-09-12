package com.example;

import java.util.Random;

/**
 * Created by lnielsen on 9/11/16.
 */
public class Cow extends Animal {

    public Cow(String name, String color){
        super(4, name, color, "cow", new Random().nextInt(100)+100);
    }

    public void grow() {
        setWeight(getWeight()*5);
    }
}
