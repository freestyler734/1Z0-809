package com.company.designPatternsAndPrinciples.functionalInterfaces;

// Пример функционального интерфейса
@FunctionalInterface // аннотация позволяет избежать ошибок объявления Функ. Интерфейса
public interface MyFunctionalInterface {

    // константа
    String name = "MyFunctionalInterface";

    // дефолтный метод
    default void method1() {
        System.out.println("Default method1");
    }

    // статический метод
    static void method2(){
        System.out.println("Static method2");
    }

    // абстрактный метод
    void method3();

    // в функц. интерфейсе не м.б. > 1 абстрактного метода
    // void method4();
}
