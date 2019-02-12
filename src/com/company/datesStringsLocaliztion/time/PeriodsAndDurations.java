package com.company.datesStringsLocaliztion.time;

import com.company.genericsAndCollections.common.Duck;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodsAndDurations {

    public static void main(String[] args) {
        /// Period ///
        // of
        Period annually = Period.ofYears(1);
        Period quarterly = Period.ofMonths(3);
        Period everyThreeWeeks = Period.ofWeeks(3);
        Period everyTwoDays = Period.ofDays(2);
        Period everyYearAndAWeek = Period.of(1,0,7);
        System.out.println("Period.ofYears(1): " + annually);
        System.out.println("Period.ofMonths(3): " + quarterly);
        System.out.println("Period.ofWeeks(3): " + everyThreeWeeks);
        System.out.println("Period.ofDays(2): " + everyTwoDays);
        System.out.println("Period.of(1,0,7): " + everyYearAndAWeek);
        System.out.println("");

        // between(LocalDate d1, LocalDate d2)
        Period between = Period.between(LocalDate.now(), LocalDate.now().minusYears(1).minusDays(240));
        System.out.println("Period.between(LocalDate.now(), LocalDate.now().minusYears(1).minusDays(240)): " + between);

        System.out.println("");


        System.out.println("----------------------------");


        /// Duration ///
        //of
        Duration daily = Duration.ofDays(1);
        Duration hourly = Duration.ofHours(1);
        Duration everyTwoMinutes = Duration.ofMinutes(2);
        Duration everyFiveSeconds = Duration.ofSeconds(5);
        Duration everyMilli = Duration.ofMillis(1);
        Duration everyNano = Duration.ofNanos(1);
        Duration chronoDays = Duration.of(10, ChronoUnit.DAYS);
        System.out.println("Duration.ofDays(1): " + daily);
        System.out.println("Duration.ofHours(1): " + hourly);
        System.out.println("Duration.ofMinutes(2): " + everyTwoMinutes);
        System.out.println("Duration.ofSeconds(5): " + everyFiveSeconds);
        System.out.println("Duration.ofMillis(1): " + everyMilli);
        System.out.println("Duration.ofNanos(1): " + everyNano);
        System.out.println("Duration.of(10, ChronoUnit.DAYS): " + chronoDays);
        System.out.println("");

        // between(Temporal t1, Temporal t2) м.б. LocalDate, LocalDateTime, ZonedDateTime(все что содержит время)
        Duration betweenDuration1 = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusYears(1).minusDays(240));
        Duration betweenDuration2 = Duration.between(ZonedDateTime.now(), ZonedDateTime.now().minusYears(1).plusDays(240).minusMinutes(123));
        Duration betweenDuration3 = Duration.between(LocalTime.now(), LocalTime.now().plusHours(3).plusMinutes(20));
        System.out.println("Duration.between(LocalDateTime.now(), LocalDateTime.now().minusYears(1).minusDays(240)): " + betweenDuration1);
        System.out.println("Duration.between(ZonedDateTime.now(), ZonedDateTime.now().minusYears(1).minusDays(240).minusMinutes(123)): " + betweenDuration2);
        System.out.println("Duration.between(LocalTime.now(), LocalTime.now().minusHours(123)): " + betweenDuration3);

    }
}
