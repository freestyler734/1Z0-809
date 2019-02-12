package com.company.datesStringsLocaliztion.i18n_and_l10n;

import java.util.Locale;

public class LocaleExample {

    public static void main(String[] args) {
        Locale local = Locale.getDefault();
        System.out.println(local);
        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);
        System.out.println(new Locale("radu"));
        System.out.println(new Locale("asd", "asd"));
        System.out.println(new Locale("ds", "",""));
        System.out.println(new Locale("z", "","s"));

        Locale locale2 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("RU")
                .build();
        System.out.println(locale2);

        Locale.setDefault(locale2);
        System.out.println(Locale.getDefault());
    }
}
