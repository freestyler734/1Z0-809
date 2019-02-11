package com.company.datesStringsLocaliztion.time;

import java.time.*;

public class Common {

    public static void main(String[] args) {
        // now()
        System.out.println("LocalDate.now(): " + LocalDate.now());
        System.out.println("LocalTime.now(): " + LocalTime.now());
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());
        System.out.println("");

        // isBefore()
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("localDate.isBefore(LocalDate.of(2019, 1,2)): " + localDate.isBefore(LocalDate.of(2019, 1,2)));
        System.out.println("localTime.isBefore(localTime.minusHours(1)): " + localTime.isBefore(localTime.minusHours(1)));
        System.out.println("localDateTime.isBefore(localDateTime.plusDays(1)): " + localDateTime.isBefore(localDateTime.plusDays(1)));
        System.out.println("zonedDateTime.isAfter(zonedDateTime.minusHours(12)): " + zonedDateTime.isAfter(zonedDateTime.minusHours(12)));
        System.out.println("");

        // toEpochDay() - только для LocalDate
        long dayCount = localDate.toEpochDay();
        System.out.println("localDate.toEpochDay(): " + dayCount);

        // toEpochSenonds() - только для LocalDateTime и ZonedDateTime
        long secCount = localDateTime.toEpochSecond(ZoneOffset.of("+0"));
        long zonedSecCount = zonedDateTime.toEpochSecond();

    }
}
