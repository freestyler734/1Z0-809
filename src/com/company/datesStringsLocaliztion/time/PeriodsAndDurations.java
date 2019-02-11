package com.company.datesStringsLocaliztion.time;

import java.time.Period;

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
    }
}
