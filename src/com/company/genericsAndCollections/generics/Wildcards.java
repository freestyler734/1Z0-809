package com.company.genericsAndCollections.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    public static void main(String[] args) {
        // примеры wildcard
        List<?> l1 = new ArrayList<String>(); // без границ
        List<? super Exception> l2 = new ArrayList<Object>(); // нижняя граница(граница потомок)
        List<? extends RuntimeException> l3 = new ArrayList<ClassCastException>(); // верхняя граница(граница родитель)

        /// Нельзя присваивать переменным с указанным типом отличный от него ////
        /// Правило присваивания переменных не работает////
        List<Integer> l4 = new ArrayList<>();
        //List<Number> l5 = new ArrayList<Integer>(); // не компилится
        //List<Object> l6 = l4; // не компилится

        //// В коллекцию с верхней границей(граница родитель) нельзя добавлять объекты ///
        List<String> l7 = new ArrayList<>();
        l1 = l7;
        // l1.add(""); не компилится

    }

    // мы можем получать объекты с коллекции через переменную с указанной верхней границей
    // т.к. вне зависимости от того объект с каким типом передадут, его элементы - наследники Number
    // и компилятор сможет их привести
    ////////////////////////////
    // не можем добавлять элементы т.к. не известен тип элементов передаваемого объекта,
    // поэтому незнаем какие элементы хранит коллекция
    public static void m1(List<? extends Number> list) {
        Number n = list.get(0);
    }

    public static void m2(List<? super IOException> list) {
        list.add(new IOException());
        list.add(new FileNotFoundException());

        Object o = list.get(0);
    }
}
