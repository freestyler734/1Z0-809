package com.company.designPatternsAndPrinciples.patterns.factory;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ItemFactory.getItem("table").printName();
    }
}
