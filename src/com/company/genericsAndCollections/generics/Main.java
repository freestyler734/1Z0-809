package com.company.genericsAndCollections.generics;

import com.company.genericsAndCollections.generics.ParametrizedClass;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Пример использования класса с дженериком
        // используем <> оператор из java 7
        ParametrizedClass<String, Number> o1 = new ParametrizedClass<>("string", new Integer(1));
        String s = o1.getObject1();
        Integer i = (Integer) o1.getObject2();

        ////////////////////////////////////////////////////////////
        // Пример использования класса с дженериком без указания конкретного типа.
        // В этом случае используется Object
        ParametrizedClass o2 = new ParametrizedClass(new String(), new String());


    }
}
