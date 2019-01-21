package com.company.designPatternsAndPrinciples.patterns.factory;

/**
 * Один из возвращаемых фабрикой типов
 */
public class Notebook extends Item {

    // делаем конструктор доступным только в этом пакете
    Notebook(){}

    @Override
    void printName() {
        System.out.println("Notebook");
    }
}
