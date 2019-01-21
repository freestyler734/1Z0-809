package com.company.designPatternsAndPrinciples.patterns.factory;

/**
 * Один из возвращаемых фабрикой типов
 */
public class Pen extends Item {

    // делаем конструктор доступным только в этом пакете
    Pen() {}
    @Override
    void printName() {
        System.out.println("Pen");
    }


}
