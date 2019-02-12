package com.company.datesStringsLocaliztion.time;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class InstantExample {

    public static void main(String[] args) {

        /// Cтатические методы ///

        // now()
        Instant now = Instant.now();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Instant later = Instant.now();
        System.out.println("Instant.now(): " + now);
        System.out.println("Instant.now(): " + later);
        System.out.println("");

        // ofEpochSeconds/ofEpochMilli
        Instant instantSec = Instant.ofEpochSecond(123123123123L);
        Instant instantMilli = Instant.ofEpochMilli(123123123123L);
        System.out.println("Instant.ofEpochSecond(123123123123L): " + instantSec);
        System.out.println("Instant.ofEpochSecond(123123123123L): " + instantMilli);
        System.out.println("");

        System.out.println("------------------------------");


        /// Нестатические методы ///
        // plus/minus(TemporalAmount a)
        now = now.minus(Period.ofWeeks(1));
        System.out.println("now.minus(Period.ofWeeks(1)): " + now);
        now = now.plus(Duration.ofDays(1));
        System.out.println("Duration.ofDays(1): " + now);
        System.out.println("");

        // plus/minus(long a, TemporalUnit u) // от ChronoUnit.DAYS до ChronoUnit.NANOS (включительно)
        now = now.plus(1, ChronoUnit.DAYS);
        System.out.println("now.plus(1, ChronoUnit.DAYS): " + now);
        now = now.minus(231, ChronoUnit.NANOS);
        System.out.println("now.minus(231, ChronoUnit.NANOS): " + now);
        System.out.println("");

        // plusSeconds(), plusMillis(), plusNanos()
        // minusSeconds(), minusMillis(), minusNanos()
        now = now.plusMillis(123123);
        System.out.println("now.plusMillis(123123): " + now);
        now = now.minusSeconds(124124);
        System.out.println("now.minusSeconds(124124): " + now);
        now = now.minusNanos(124124);
        System.out.println("now.minusNanos(124124): " + now);
        System.out.println("");

    }
}
