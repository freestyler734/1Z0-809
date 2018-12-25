package com.company.advancedClassDesign.nestedClasses.innerClasses;

import com.company.advancedClassDesign.nestedClasses.innerClasses.Outer.*;

public class Main {

    public static void main(String[] args) {
        Outer o1 = new Outer();
        System.out.println(o1);
        System.out.println("============================");

        Outer.Inner o1Inner = o1.new Inner();
        System.out.println(o1);

        Inner i2 = o1.new Inner();

    }
}
