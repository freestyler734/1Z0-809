package com.company.io.streamUsage.serialization;

import java.io.Serializable;

public class Animal  {

    protected String name;
    protected int age;

    {
        age = 1;
    }

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Animal(){
        name = "Just an Animal";
    }
}
