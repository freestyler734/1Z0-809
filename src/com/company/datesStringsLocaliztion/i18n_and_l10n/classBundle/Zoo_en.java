package com.company.datesStringsLocaliztion.i18n_and_l10n.classBundle;

import java.util.ListResourceBundle;

public class Zoo_en  extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", "Hello!", "asd"},
                {"open", "The zoo is open!", "asdasd"}
        };
    }
}
