package com.company.advancedClassDesign.nestedClasses.localClasses;

public class Main {

    public String enclosingField = "enclosingField";

    public static String staticField = "staticField";

    public Object method() {

        // Фактически final - поэтому можем использовать
        // в локальном классе
        String methodName = "Just a method";

        class LocalClass {

            public void m() {
                System.out.println(staticField);
                System.out.println(enclosingField + " from " + methodName);
            }
        }
        //methodName = "";
        LocalClass lc = new LocalClass();
        lc.m();
        return lc;
    }

    public static void main(String[] args) {
      new Main().method();
    }


}
