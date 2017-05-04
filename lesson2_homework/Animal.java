package com.example;

/**
 * Created by lnielsen on 9/11/16.
 */
public abstract class Animal {

    private int legs;
    private String name;
    private String color;
    private String species;
    private double weight;

    public Animal(int legs, String name, String color, String species, double weight) {
        this.legs = legs;
        this.name = name;
        this.color = color;
        this.species = species;
        this.weight = weight;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void grow();
}

// Usually clean up code and removing stuff that is not being used.

//public abstract class Vehicle {
//
//    int wheels;
//
//    public Vehicle(int wheels) {
//        this.wheels = wheels;
//    }
//
//    public int getWheels() {
//        return wheels;
//    }
//
//    public abstract void turnOn();
//}