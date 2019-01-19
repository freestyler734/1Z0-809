package com.company.designPatternsAndPrinciples.patterns.factory;

public class Main {

    public static void main(String[] args) {
        ItemFactory.getItem("table").printName();
    }
}
