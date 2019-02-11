package com.company.datesStringsLocaliztion.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

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
        System.out.println("localDateTime.toEpochSecond(ZoneOffset.of(\"+0\")): " + secCount);
        System.out.println("zonedDateTime.toEpochSecond(): " + zonedSecCount);
        System.out.println("");

        // plus()/minus()
        Period period = Period.ofWeeks(10);
        System.out.println("period: " + period);
        System.out.println("localDate.plus(period): " + localDate.plus(period));
        System.out.println("localDateTime.minus(period): " + localDateTime.minus(period));
        System.out.println("zonedDateTime.minus(period): " + zonedDateTime.minus(period));
        System.out.println("");

        // ChronoUnit beetween
        zonedDateTime = ZonedDateTime.now();
        localTime = LocalTime.of(20,18);
        localDateTime = LocalDateTime.of(localDate.plusDays(78).plusYears(2), localTime.plusMinutes(200));
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("zonedDateTime: " + zonedDateTime);
        System.out.println("localTime: " + localTime);
        System.out.println("ChronoUnit.DAYS.between(localDateTime, zonedDateTime): " + ChronoUnit.DAYS.between(localDateTime, zonedDateTime));
        System.out.println("ChronoUnit.DAYS.between(localTime, zonedDateTime): " + ChronoUnit.HALF_DAYS.between(localTime, zonedDateTime)); // LocalTime не содержит дни
        System.out.println("ChronoUnit.HOURS.between(localTime, zonedDateTime): " + ChronoUnit.HOURS.between(localTime, zonedDateTime));
    }
}
