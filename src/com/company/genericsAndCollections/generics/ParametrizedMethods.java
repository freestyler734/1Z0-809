package com.company.genericsAndCollections.generics;

public class ParametrizedMethods {

    // пример обобщенного метода
    public static <T> T m1(T o){
        return o;
    }

    // пример обобщенного нестатического метода
    public <T>void m2(T o) { }

    public static <T, U>ParametrizedClass<T, U> m3(){
        return new ParametrizedClass<>();
    }

    public static void main(String[] args) {
        // если не указываем конкретный тип, компилятор распознает его автоматически
        ParametrizedMethods.m1("");
        ParametrizedMethods.<String>m1("");


        // т.к. нет вх. параметров, автоматически определить типы не получится
        // поэтому указываем их вручную
        ParametrizedMethods.<String, Integer>m3();


    }

    void method() {
        this.<String>m2("");
    }
}
