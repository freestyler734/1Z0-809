package com.company.datesStringsLocaliztion.time;

import com.company.genericsAndCollections.common.Duck;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodsAndDurations {

    public static void main(String[] args) {
        // Period
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

        System.out.println("----------------------------");

        // Duration
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
    }
}
