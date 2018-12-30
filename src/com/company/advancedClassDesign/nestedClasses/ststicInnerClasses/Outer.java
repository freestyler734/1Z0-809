package com.company.advancedClassDesign.nestedClasses.ststicInnerClasses;

public class Outer {

    private static int age = 1;
    private String name = "Outer";

    static class Inner {

        public static int weight = 2;
        private int k = 3;

        public void method() {
            System.out.println(age);
        }
    }

    public void m(){
        System.out.println(Inner.weight);
        System.out.println(new Inner().k);

    }
}
