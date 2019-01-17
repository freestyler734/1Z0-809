package com.company.designPatternsAndPrinciples.patterns.builder;

import com.company.designPatternsAndPrinciples.patterns.immutableObject.Pet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> l = new ArrayList();
        l.add("1");
        l.add("2");

        Pet pet = new PetBuilder().setName("1").setAge(2).setToys(l).build();
        System.out.println(pet);

        l.add("3");
        System.out.println(pet);
    }
}
