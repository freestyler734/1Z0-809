package com.company.datesStringsLocaliztion.formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormating {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();


        // Примеры использования класса DateTimeFormatter
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.BASIC_ISO_DATE;
     // System.out.println("BASIC_ISO_DATE.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
        System.out.println("BASIC_ISO_DATE.format(date): " + formatter.format(date));
        System.out.println("BASIC_ISO_DATE.format(dateTime): " + formatter.format(dateTime));
        System.out.println("BASIC_ISO_DATE.format(zonedDateTime): " + formatter.format(zonedDateTime));

        formatter = DateTimeFormatter.ISO_DATE;
     // System.out.println("ISO_DATE.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
        System.out.println("ISO_DATE.format(date): " + formatter.format(date));
        System.out.println("ISO_DATE.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_DATE.format(zonedDateTime): " + formatter.format(zonedDateTime));

        formatter = DateTimeFormatter.ISO_LOCAL_DATE;
     // System.out.println("ISO_LOCAL_DATE.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
        System.out.println("ISO_LOCAL_DATE.format(date): " + formatter.format(date));
        System.out.println("ISO_LOCAL_DATE.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_LOCAL_DATE.format(zonedDateTime): " + formatter.format(zonedDateTime));
        System.out.println("");

        formatter = DateTimeFormatter.ISO_TIME;
        System.out.println("ISO_TIME.format(time): " + formatter.format(time));
     // System.out.println("ISO_TIME.format(date): " + formatter.format(date)); // UnsupportedTemporalTypeException
        System.out.println("ISO_TIME.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_TIME.format(zonedDateTime): " + formatter.format(zonedDateTime));

        formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println("ISO_LOCAL_TIME.format(time): " + formatter.format(time));
     // System.out.println("ISO_LOCAL_TIME.format(date): " + formatter.format(date)); // UnsupportedTemporalTypeException
        System.out.println("ISO_LOCAL_TIME.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_LOCAL_TIME.format(zonedDateTime): " + formatter.format(zonedDateTime));
        System.out.println("");

        formatter = DateTimeFormatter.ISO_DATE_TIME;
     // System.out.println("ISO_DATE_TIME.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
     // System.out.println("ISO_DATE_TIME.format(date): " + formatter.format(date)); // UnsupportedTemporalTypeException
        System.out.println("ISO_DATE_TIME.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_DATE_TIME.format(zonedDateTime): " + formatter.format(zonedDateTime));

        formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
     // System.out.println("ISO_LOCAL_DATE_TIME.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
     // System.out.println("ISO_LOCAL_DATE_TIME.format(date): " + formatter.format(date)); // UnsupportedTemporalTypeException
        System.out.println("ISO_LOCAL_DATE_TIME.format(dateTime): " + formatter.format(dateTime));
        System.out.println("ISO_LOCAL_DATE_TIME.format(zonedDateTime): " + formatter.format(zonedDateTime));
        System.out.println("");
        formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
     // System.out.println("ISO_ZONED_DATE_TIME.format(time): " + formatter.format(time)); // UnsupportedTemporalTypeException
     // System.out.println("ISO_ZONED_DATE_TIME.format(date): " + formatter.format(date)); // UnsupportedTemporalTypeException
     // System.out.println("ISO_ZONED_DATE_TIME.format(dateTime): " + formatter.format(dateTime)); // UnsupportedTemporalTypeException
        System.out.println("ISO_ZONED_DATE_TIME.format(zonedDateTime): " + formatter.format(zonedDateTime));
        System.out.println("");
        System.out.println("----------------");
        System.out.println("");


        // Метод ofLocalized"Тип"
        FormatStyle fullStyle = FormatStyle.FULL;
        FormatStyle longStyle = FormatStyle.LONG;
        FormatStyle mediumStyle = FormatStyle.MEDIUM;
        FormatStyle shortStyle = FormatStyle.SHORT;

        // ofLocalizedTime(FormatStyle s)
     // System.out.println("time.format(DateTimeFormatter.ofLocalizedTime(fullStyle)): " +  time.format(DateTimeFormatter.ofLocalizedTime(fullStyle))); // DateTimeException
     // System.out.println("time.format(DateTimeFormatter.ofLocalizedTime(longStyle)): " +  time.format(DateTimeFormatter.ofLocalizedTime(longStyle))); // DateTimeException
        System.out.println("time.format(DateTimeFormatter.ofLocalizedTime(mediumStyle)): " +  time.format(DateTimeFormatter.ofLocalizedTime(mediumStyle)));
        System.out.println("time.format(DateTimeFormatter.ofLocalizedTime(shortStyle)):  " + time.format(DateTimeFormatter.ofLocalizedTime(shortStyle)));
        System.out.println("");

        // ofLocalizedDate(FormatStyle s)
        System.out.println("date.format(DateTimeFormatter.ofLocalizedDate(fullStyle)): " + date.format(DateTimeFormatter.ofLocalizedDate(fullStyle)));
        System.out.println("date.format(DateTimeFormatter.ofLocalizedDate(longStyle)): " + date.format(DateTimeFormatter.ofLocalizedDate(longStyle)));
        System.out.println("date.format(DateTimeFormatter.ofLocalizedDate(mediumStyle)): " + date.format(DateTimeFormatter.ofLocalizedDate(mediumStyle)));
        System.out.println("date.format(DateTimeFormatter.ofLocalizedDate(shortStyle)): " + date.format(DateTimeFormatter.ofLocalizedDate(shortStyle)));
        System.out.println("");

        // ofLocalizedDateTime(FormatStyle s)
     // System.out.println("dateTime.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle)): " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle))); // DateTimeException
     // System.out.println("dateTime.format(DateTimeFormatter.ofLocalizedDateTime(longStyle)): " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(longStyle))); // DateTimeException
        System.out.println("dateTime.format(DateTimeFormatter.ofLocalizedDateTime(mediumStyle)): " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(mediumStyle)));
        System.out.println("dateTime.format(DateTimeFormatter.ofLocalizedDateTime(shortStyle)): " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(shortStyle)));

        System.out.println("zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle)): " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle))); // DateTimeException
        System.out.println("zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(longStyle)): " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(longStyle))); // DateTimeException
        System.out.println("zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(mediumStyle)): " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(mediumStyle)));
        System.out.println("zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(shortStyle)): " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(shortStyle)));



        // ofPattern(String s)
        // DateTimeFormatter.ofPattern()

    }
}
