package com.company.datesStringsLocaliztion.i18n_and_l10n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
        Locale enLocale = new Locale("en");
        Locale frLocale = new Locale("fr");

        printProperties(enLocale);
        System.out.println("----------");
        printProperties(frLocale);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle zooBundle = ResourceBundle.getBundle("com/company/datesStringsLocaliztion/i18n_and_l10n/Zoo", locale);
        String hello = zooBundle.getString("hello");
        String open = zooBundle.getString("open");
        System.out.println(hello);
        System.out.println(open);
    }
}
