package com.company.advancedClassDesign.nestedClasses.ststicInnerClasses;


// Оба варианта работают
import com.company.advancedClassDesign.nestedClasses.ststicInnerClasses.Outer.Inner;
import static com.company.advancedClassDesign.nestedClasses.ststicInnerClasses.Outer.Inner;


public class Main {

    public static void main(String[] args) {
        Outer.Inner i = new Outer.Inner();
        Inner i2 = new Inner();

    }
}
