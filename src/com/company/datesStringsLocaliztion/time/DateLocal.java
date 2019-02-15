package com.company.datesStringsLocaliztion.time;

import java.time.LocalDate;

public class DateLocal {

    public static void main(String[] args) {
        // Основные методы для оперирования временными единицами
        LocalDate date = LocalDate.of(2019,1,1);
        System.out.println("date: " + date);
        System.out.println("");
        System.out.println("date.plusYears(1): " + date.plusYears(10000000));
        System.out.println("date.minusYears(2021): " + date.minusYears(2021));
        System.out.println("");
        System.out.println("date.plusMonths(13): " + date.plusMonths(13));
        System.out.println("date.minusMonths(13): " + date.minusMonths(13));
        System.out.println("");
        System.out.println("date.plusWeeks(10): " + date.plusWeeks(10));
        System.out.println("date.minusWeeks(10): " + date.minusWeeks(10));
        System.out.println("");
        System.out.println("date.plusDays(32): " + date.plusDays(32));
        System.out.println("date.minusDays(32): " + date.minusDays(32));
        System.out.println("");
        System.out.println("------------");

        // Т.к. класс неизменяемый,
        // пример метод-чейна
        LocalDate chainedDate = date.minusYears(2020)
                .plusMonths(15)
                .minusWeeks(12)
                .plusDays(2);
        System.out.println("chainedDate: " + chainedDate);
        System.out.println("");
        System.out.println("------------");

        // методы get"TimeUnit"()
        System.out.println(date);
        System.out.println("date.getYear(): " + date.getYear()); // int
        System.out.println("date.getMonth(): " + date.getMonth()); // Month
        System.out.println("date.getMonthValue(): " + date.getMonthValue()); // int
        System.out.println("date.getDayOfYear(): " + date.getDayOfYear()); // int
        System.out.println("date.getDayOfMonth() + " + date.getDayOfMonth()); // int
        System.out.println("date.getDayOfWeek(): " + date.getDayOfWeek()); // DayOfWeek
    }
}
