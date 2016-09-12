package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by lnielsen on 9/11/16.
 */
public class Farm {

    private ArrayList<Animal> animalArrayList;

    public Farm() {
        this(new ArrayList<Animal>());
    }

    public Farm(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    public void addAnimal(Animal animal) {
        animalArrayList.add(animal);
    }

    public Animal getAnimal(int index) {
        return animalArrayList.get(index);
    }

    public ArrayList<Animal> getHeaviestAnimals() {
        ArrayList<Animal> inOrder = new ArrayList<>(animalArrayList);
        Collections.sort(inOrder, new Comparator<Animal>() {
            @Override
            public int compare(Animal a, Animal b) {
                double diff = a.getWeight() - b.getWeight();
                if (diff < 0)
                    return 1;
                if (diff == 0)
                    return 0;
                return -1;
            }
        });
        return inOrder;
    }

    public void printCatNames() {
        for(Animal a : animalArrayList) {
            if (a.getSpecies().toLowerCase().equals("cat"))
                System.out.println(a.getName());

        }
    }

    public double averageLegs() {
        double num_legs = 0;
        int index = 0;
        for (Animal a : animalArrayList) {
            num_legs += a.getLegs();
            index += 1;
        }
        return num_legs/index;
    }
}
