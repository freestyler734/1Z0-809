package com.company.exceptionsAndAssertions.assertions;

public class AssertionExamples {

    public static void main(String[] args) {

        // Уттверждения используются при дебагге, обычно на продакшене их отключают
        // используют логическое условие(true/false)
        assert 1==1;
        assert 1==1: "Exception text"; // после ":" текст для java.lang.AssertionError, если условие false

        assert 2==1;
        assert 2==1: "Exception text";
    }
}
