package com.company.advancedClassDesign.instanceOf;

import java.io.Serializable;
import java.util.ArrayList;

class Animal{}
class Tiger extends Animal implements Serializable{}
class Wolf extends Animal{}


public class Main {

    public static void main(String[] args) {

        Object o = new String();
        System.out.println(o instanceof ArrayList);

        boolean b = null instanceof ArrayList;

        Animal animal = new Animal();
        Animal anTiger = new Tiger();
        Tiger tiger = new Tiger();

        System.out.println(animal instanceof Animal);
        System.out.println(anTiger instanceof Tiger);
        System.out.println(anTiger instanceof Wolf);
        //System.out.println(tiger instanceof Wolf);
        System.out.println(tiger instanceof Animal);
        System.out.println(animal instanceof Serializable);



    }
}
