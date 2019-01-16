package com.company.designPatternsAndPrinciples.patterns.immutableObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> l = new ArrayList();
        l.add("1");
        l.add("2");
        // тест на изменение коллекции
        Pet pet1 = new Pet("1", 2, l);
        System.out.println(pet1);
        l.add("3");
        System.out.println(pet1);

        Pet pet2 = pet1.addYear(2);
        System.out.println(pet1);
        System.out.println(pet2);


    }
}
