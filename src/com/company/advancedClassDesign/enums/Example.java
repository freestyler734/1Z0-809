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
    }
}
