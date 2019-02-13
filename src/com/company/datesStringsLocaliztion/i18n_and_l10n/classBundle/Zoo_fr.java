package com.company.datesStringsLocaliztion.i18n_and_l10n.classBundle;

import java.util.ListResourceBundle;

public class Zoo_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            {"hello", "Bonjour!"},
            {"open", "Le Zoo est ouvert! \nasdasd"}
        };
    }
}
