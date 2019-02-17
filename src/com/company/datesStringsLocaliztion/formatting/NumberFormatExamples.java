package com.company.datesStringsLocaliztion.formatting;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/*
    Примеры использование класса NumberFormat для форматирования и парсинга чисел, валют процентов
 */
public class NumberFormatExamples {

    public static void main(String[] args) {

        /// Основные методы создания ///

        // возвращает общий объект форматирования для дефолтной локали (то же самое что и getNumberInstance())
        NumberFormat defaultFormat = NumberFormat.getInstance();
        // возвращает общий объект форматирования для переданной локали (то же самое что и getNumberInstance(Locale l))
        NumberFormat localeFormat = NumberFormat.getInstance(new Locale("en", "US"));

        // то же что и getInstance
        NumberFormat defaultNumberFormat = NumberFormat.getNumberInstance();
        NumberFormat localeNumberFormat = NumberFormat.getNumberInstance(new Locale("en", "US"));

        // работа с валютами
        NumberFormat defaultCurrencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat localeCurrencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        // работа с процентами
        NumberFormat defaultPercentFormat = NumberFormat.getPercentInstance();
        NumberFormat localePercentFormat = NumberFormat.getPercentInstance(new Locale("en", "US"));

        // то же, что и getNumberInstance, но округляет рез-т до большего целого
        NumberFormat defaultIntegerFormat = NumberFormat.getIntegerInstance();
        NumberFormat localeIntegerFormat = NumberFormat.getIntegerInstance(new Locale("en", "US"));


        /// format метод (число/объект в String) ///
        double d = 100000.7123234;
        // String format(...)
        System.out.println("defaultFormat: " + defaultFormat.format(d));
        System.out.println("localeFormat:  " + localeFormat.format(d));
        System.out.println("");
        System.out.println("defaultNumberFormat: " + defaultNumberFormat.format(d));
        System.out.println("localeNumberFormat:  " + localeNumberFormat.format(d));
        System.out.println("");
        System.out.println("defaultCurrencyFormat: " + defaultCurrencyFormat.format(d));
        System.out.println("localeCurrencyFormat:  " + localeCurrencyFormat.format(d));
        System.out.println("");
        System.out.println("defaultPercentFormat: " + defaultPercentFormat.format(d));
        System.out.println("localePercentFormat:  " + localePercentFormat.format(d));
        System.out.println("");
        System.out.println("defaultIntegerFormat: " + defaultIntegerFormat.format(d));
        System.out.println("localeIntegerFormat:  " + localeIntegerFormat.format(d));
        System.out.println("");
        System.out.println("-");

        // Основные перегрузки format на примере defaultFormat (одинаковы для всех типов)
        System.out.println("defaultFormat.format(10000000L): " + defaultFormat.format(10000000L)); // long
        System.out.println("defaultFormat.format(0.123421): " + defaultFormat.format(0.123421)); // double (округляет до тысячных)
        System.out.println("defaultFormat.format(new Integer(1234123214)): " + defaultFormat.format(new Integer(1234123214))); // Object
        System.out.println("");
        System.out.println("------------------------------------------------");


        /// parse метод (String в число/объект) - возвращает Number ///
        /// есть аналог parseObject - возвращает Object             ///
        /// ВЫБРАСЫВАЕТ ПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ  ParseException      ///
        try {
            // минус для чисел о.к.
            // отбрасывается часть после "." , т.к. в России дробная часть после "," и "." в числах вообще не используется(т.е. это как незнакомый символ для этой locale).
            // В таких случаях java парсит только первую часть строки(если это число, иначе Exception)
            System.out.println("defaultFormat.parse(\"45.23\"): "+ defaultFormat.parse("-45.23234"));
            // а Америке дробная часть "."
            System.out.println("localeFormat.parse(\"45.23\"): "+ localeFormat.parse("-45.2343242"));
            // После незнакомой для данной locale части строки, парсинг не происходит
            System.out.println("defaultFormat.parse(\"45.23\"): "+ defaultFormat.parse("-45ыва23"));
            // Exception, т.к. парсится с начала, а там не число
            // System.out.println("defaultFormat.parse(\"45.23\"): "+ defaultFormat.parse("фыв45ыва23"));
            System.out.println("");

            // минус для валют ошибка
            // знак $ для российской валюты не походит
            // System.out.println(defaultCurrencyFormat.parse("$1.71"));
            System.out.println("localeCurrencyFormat.parse(\"$1.71\"): " + localeCurrencyFormat.parse("$1.71"));
            System.out.println("");

            // минус для процентов о.к. и знак "%" обязателен
            System.out.println("defaultPercentFormat.parse(\"-120%\"): " + defaultPercentFormat.parse("-120%"));
            System.out.println("localePercentFormat.parse(\"-120%\"):  " + localePercentFormat.parse("-120%"));
            System.out.println("");

            // минус для чисел о.к.
            System.out.println(defaultIntegerFormat.parse("-123,7"));
            // В Америке "," разделяют числа(как у нас отступами, но здесь это не работает)
            System.out.println(localeIntegerFormat.parse("-123,3"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
