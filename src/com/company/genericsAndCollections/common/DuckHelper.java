package com.company.genericsAndCollections.common;

public class DuckHelper {

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }

    public static int compareByAge(Duck d1, Duck d2) {
        return d1.getAge() - d2.getAge();
    }

    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }
}
