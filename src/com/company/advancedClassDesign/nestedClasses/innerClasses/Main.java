package com.company.advancedClassDesign.nestedClasses.innerClasses;

import com.company.advancedClassDesign.nestedClasses.innerClasses.Outer.*;

public class Main {

    public static void main(String[] args) {
        Outer o1 = new Outer();
        System.out.println(o1);
        System.out.println("============================");

        Outer.Inner o1Inner = o1.new Inner();
        System.out.println(o1);

        // такой спосиоб объявления переменной внутреннего класса доступен,
        // т.к. мы импортировали члены класса Outer
        Inner i2 = o1.new Inner();

        System.out.println("============================");
        A.B.C c = new A().new B().new C();
        c.printAllX();
    }
}
