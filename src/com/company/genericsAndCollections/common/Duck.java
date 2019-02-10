package com.company.genericsAndCollections.common;

public class Duck {
    private String name;
    private int age;
    private int weight;

    public Duck(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String method(int i, String s) {
        return "age: " + (this.getAge() + i) + ", name: " + (this.getName() + s);
    }
}
