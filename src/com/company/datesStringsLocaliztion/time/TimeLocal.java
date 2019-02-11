package com.company.datesStringsLocaliztion.time;

import java.time.LocalTime;
import java.time.Period;

public class TimeLocal {

    public static void main(String[] args) {
        LocalTime time = LocalTime.of(0,0,0,0);
        System.out.println(time);
        System.out.println("");

        // Основные методы для оперирования временными единицами
        System.out.println("time.plusHours(2): " + time.plusHours(2));
        System.out.println("time.minusHours(2): " + time.minusHours(2));
        System.out.println("");
        System.out.println("time.plusMinutes((24 * 60) + 1)): " + time.plusMinutes((24 * 60) + 1)); // прибавляем сутки + 1 минуту
        System.out.println("time.minusMinutes(20): " + time.minusMinutes(20));
        System.out.println("");
        System.out.println("time.plusSeconds(360): " + time.plusSeconds(360));
        System.out.println("time.minusSeconds(360): " + time.minusSeconds(360));
        System.out.println("");
        System.out.println("time.plusNanos(10000): " + time.plusNanos(10000));
        System.out.println("time.minusNanos(10000000): " + time.minusNanos(10000000));
        System.out.println("------------");

        // Т.к. класс неизменяемый,
        // пример метод-чейна
        LocalTime chainedTime = LocalTime.of(0,0,0,0)
                                        .plusHours(23)
                                        .minusMinutes(12)
                                        .plusSeconds(20)
                                        .minusNanos(1);
        System.out.println("chainedTime: " + chainedTime);

    }
}
