package com.company.advancedClassDesign.enums;

import java.lang.ref.SoftReference;

public class Example {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println("==================");
        System.out.println("spring == Season.SPRING: " + (spring == Season.SPRING));
        System.out.println("==================");

        Season[] seasons = Season.values();
        for (Season season: seasons) {
            System.out.println(season.ordinal() + ": " + season.name());
        }
        System.out.println("==================");

        switch (spring) {
            case SPRING:
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
            case FALL:
                System.out.println("fall");
                break;
            case WINTER:
                System.out.println("winter");
                break;
            default:
                System.out.println("no one");
                break;
        }
        System.out.println("==================");

        System.out.println(Season.valueOf("SPRING"));
        System.out.println("==================");

        Season summer = Season.SUMMER;
        summer.printVisitorsStatus();
        spring.printVisitorsStatus();

        // метод valueOf - возвращает уже созданную константу enum (из своего массива),
        // если в enum была объявлена константа с передаваемым именем(регистр важен).
        // Поэтому в данном примере константа содержит значение visitorsStatus,
        // она уже была создана раньше и ей было передано значение через конструктор
        Season.valueOf("SUMMER").printVisitorsStatus();
        System.out.println("==================");

        Season winter = Season.WINTER;
        winter.setAvgTemperature(30);
        winter.printAvgTemperature();
        spring.printAvgTemperature();
        System.out.println("==================");

        winter.printSmth();
        spring.printSmth();

       // winter.printSpecial();
    }
}
