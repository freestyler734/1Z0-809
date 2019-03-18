package com.company.io.streamUsage.serialization;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Tiger extends Animal implements Serializable {

    public static final long serialVersionUID = 1L;
    private String color;
    private transient int weight; // не дессериализуется
    private List<String> childNames;

    {
        color = "gray";
    }

    public Tiger(String name, int age, String color, int weight, List<String> childNames) {
        super(name, age);
        this.color = color;
        this.weight = weight;
        this.childNames = childNames;
    }

    public Tiger() {
        this.color = "gray";
        this.weight = 12;
        this.childNames = Arrays.asList("1", "2");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", childNames=" + childNames +
                '}';
    }
}
