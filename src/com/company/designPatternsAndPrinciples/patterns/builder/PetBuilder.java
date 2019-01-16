package com.company.designPatternsAndPrinciples.patterns.builder;

import com.company.designPatternsAndPrinciples.patterns.immutableObject.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetBuilder {

    private String name;
    private int age;
    private List<String> toys;

    public PetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PetBuilder setToys(List<String> toys) {
        this.toys = toys;
        return this;
    }

    public Pet build() {

        // не обязательно, но можно
        if (name == null) name = "Pet";
        if (age == 0) age = 1;
        if (toys == null) toys = new ArrayList<>();

        return new Pet(name, age, toys);
    }
}
