package com.company.genericsAndCollections.collections.comparing;

import java.util.*;

public class ComparableExample implements Comparable<ComparableExample> {

    private int age;
    private int weight;
    private String name;

    public ComparableExample(int age, int weight, String name) {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableExample example) {
        return this.age  - example.age;
    }

    @Override
    public String toString() {
        return this.name + ", " +
            this.age + ", " +
            this.weight;
    }

    public static void main(String[] args) {
        List<ComparableExample> list = new ArrayList<>();
        list.add(new ComparableExample(1,2, "First"));
        list.add(new ComparableExample(3,2, "Second"));
        list.add(new ComparableExample(1,2, "Third"));
        list.add(new ComparableExample(9,2, "Forth"));
        list.add(new ComparableExample(90,2, "Fifth"));

        Collections.sort(list);

        for (ComparableExample e: list) {
            System.out.println(e);
        }
    }


}
