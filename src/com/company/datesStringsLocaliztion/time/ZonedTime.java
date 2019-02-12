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
    }
}
