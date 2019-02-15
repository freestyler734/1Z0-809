package com.company.datesStringsLocaliztion.time;

import java.time.*;

public class ZonedTime {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime.now(): " + zonedDateTime);
        System.out.println("");
        ZoneId zoneId = ZoneId.of("Asia/Chita");
        System.out.println("ZonedDateTime.of(2019, 9, 30, 18,0,0,0,zoneId): " + ZonedDateTime.of(2019, 9, 30, 0,1,1,1,zoneId));
        System.out.println("ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zoneId): " + ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zoneId));
        System.out.println("ZonedDateTime.of(LocalDateTime.now(), zoneId): " + ZonedDateTime.of(LocalDateTime.now(), zoneId));
        System.out.println("");
        Instant instant = zonedDateTime.toInstant();
        System.out.println("Instant.now(): " + instant);
        System.out.println("");
        System.out.println("------------");


        // методы get"TimeUnit"()
        // все get-методы Date
        System.out.println("zonedDateTime.getYear(): " + zonedDateTime.getYear());
        System.out.println("zonedDateTime.getMonth(): " + zonedDateTime.getMonth());
        System.out.println("zonedDateTime.getMonthValue(): " + zonedDateTime.getMonthValue());
        System.out.println("zonedDateTime.getDayOfYear(): " + zonedDateTime.getDayOfYear());
        System.out.println("zonedDateTime.getDayOfMonth() + " + zonedDateTime.getDayOfMonth());
        System.out.println("zonedDateTime.getDayOfWeek(): " + zonedDateTime.getDayOfWeek());
        System.out.println("zonedDateTime.getDayOfWeek(): " + zonedDateTime.getDayOfWeek());
        // все get-методы Time
        System.out.println("zonedDateTime.getHour(): " + zonedDateTime.getHour());
        System.out.println("zonedDateTime.getMinute(): " + zonedDateTime.getMinute());
        System.out.println("zonedDateTime.getSecond(): " + zonedDateTime.getSecond());
        System.out.println("zonedDateTime.getNano(): " + zonedDateTime.getNano());
        // доп. методы
        System.out.println("zonedDateTime.getOffset(): " + zonedDateTime.getOffset());
        System.out.println("zonedDateTime.getZone(): " + zonedDateTime.getZone());
    }
}
