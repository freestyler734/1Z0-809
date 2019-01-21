package com.company.designPatternsAndPrinciples.patterns.factory;

/**
 * Один из возвращаемых фабрикой типов
 */
public class Table extends Item {

    // делаем конструктор доступным только в этом пакете
    Table(){}

    @Override
    void printName() {
        System.out.println("Table");
    }
}
