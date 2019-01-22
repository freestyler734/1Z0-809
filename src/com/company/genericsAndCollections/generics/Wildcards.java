package com.company.genericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    public static void main(String[] args) {
        // примеры wildcard
        List<?> l1 = new ArrayList<Number>(); // без границ
        List<? super Exception> l2 = new ArrayList<Object>(); // нижняя граница(граница потомок)
        List<? extends RuntimeException> l3 = new ArrayList<ClassCastException>(); // верхняя граница(граница потомок)

        ////////////////

        List<Integer> l4 = new ArrayList<>();
        //List<Number> l5 = new ArrayList<Integer>(); // не компилится
        //List<Object> l6 = l4; // не компилится
    }
}
