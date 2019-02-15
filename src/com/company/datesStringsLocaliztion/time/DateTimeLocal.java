package com.company.datesStringsLocaliztion.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class DateTimeLocal {
    public static void main(String[] args) {

        System.out.println("LocalDateTime.of(2019,9,30, 18,0,0,0,0): " + LocalDateTime.of(2019, Month.SEPTEMBER, 30, 18, 0, 0, 0));
        System.out.println("");
        System.out.println("------------");

        // методы get"TimeUnit"()
        LocalDateTime dt = LocalDateTime.now();
        // все get-методы Date
        System.out.println(dt);
        System.out.println("dt.getYear(): " + dt.getYear()); // int
        System.out.println("dt.getMonth(): " + dt.getMonth()); // Month
        System.out.println("dt.getMonthValue(): " + dt.getMonthValue()); // int
        System.out.println("dt.getDayOfYear(): " + dt.getDayOfYear()); // int
        System.out.println("dt.getDayOfMonth() + " + dt.getDayOfMonth()); // int
        System.out.println("dt.getDayOfWeek(): " + dt.getDayOfWeek()); // DayOfWeek
        // все get-методы Time
        System.out.println("dt.getHour(): " + dt.getHour()); // int
        System.out.println("dt.getMinute(): " + dt.getMinute()); // int
        System.out.println("dt.getSecond(): " + dt.getSecond()); // int
        System.out.println("dt.getNano(): " + dt.getNano()); // int

    }
}
