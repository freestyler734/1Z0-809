package com.company.datesStringsLocaliztion.i18n_and_l10n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleExample {

    public static void main(String[] args) {
        Locale enLocale = new Locale("en");
        Locale frLocale = new Locale("fr");

        printProperties(enLocale);
        System.out.println("-");
        printProperties(frLocale);
        System.out.println("");
        System.out.println("--------------");
        System.out.println("");

        ResourceBundle rb = ResourceBundle.getBundle("com/company/datesStringsLocaliztion/i18n_and_l10n/Zoo", enLocale);
        System.out.println(rb);
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + ": " + rb.getString(k))
                .forEach(System.out::println);
        System.out.println("");
        System.out.println("--------------");
        System.out.println("");

        // Properties
        Properties properties = new Properties();
        keys.forEach(k -> properties.put(k, rb.getString(k)));
        System.out.println(properties);
        System.out.println(properties.getProperty("hello", "hi"));
        System.out.println(properties.getProperty("notAkey"));
        System.out.println(properties.getProperty("notAkey", "default"));
        System.out.println("-");
        // get не перегружен с дефолтным параметром
        System.out.println(properties.get("hello"));
        System.out.println(properties.get("notAkey"));
        System.out.println("");
        System.out.println("--------------");
        System.out.println("");

        // Пример использования бандла класса
        ResourceBundle classRb = ResourceBundle.getBundle("com.company.datesStringsLocaliztion.i18n_and_l10n.classBundle.Zoo", enLocale);
        System.out.println(classRb.getString("hello"));

    }

    public static void printProperties(Locale locale) {
        ResourceBundle zooBundle = ResourceBundle.getBundle("com/company/datesStringsLocaliztion/i18n_and_l10n/Zoo", locale);
        String hello = zooBundle.getString("hello");
        String formattedHello = MessageFormat.format(hello, "lol", "kek");
        String open = zooBundle.getString("open");
        System.out.println(formattedHello);
        System.out.println(open);
    }
}
