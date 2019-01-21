package com.company.designPatternsAndPrinciples.patterns.factory;

/**
 * Один из возвращаемых фабрикой типов
 */
public class Pencil extends Item {

    // делаем конструктор доступным только в этом пакете
    Pencil(){}

    @Override
    void printName() {
        System.out.println("Pencil");
    }

}
