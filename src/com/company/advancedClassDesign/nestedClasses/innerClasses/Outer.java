package com.company.advancedClassDesign.nestedClasses.innerClasses;

public class Outer {
    private int i = 0;
    private String s = "s";
    public static String staticS = "staticS";

    public void m() {
        System.out.println("Outer m");
    }

    public class Inner implements innerInterface {

        private int innerI = 12;
        private int i;

        // нельзя объявлять статические методы и поля
        //static String innerStatic = "";

        Inner () {
            Outer.this.i = 1;
            i = 2; // берет ближайшую переменную
            s = "q";
            staticS = "staticQ";
            System.out.println(i);
        }

        public void m() {
            System.out.println("Inner m");
        }

        @Override
        public void jo() {

        }
    }

    @Override
    public String toString() {
        return ("i: " + i + ", s: " + s + ", staticS: " + staticS);
    }

    public void changeFieldValues() {

        // оба варианта корректны внутри внешнего класса
        Outer.Inner i1 = this.new Inner();
        Inner i2 = new Inner();
    }

    private interface innerInterface {
        void jo();
    }
}
