package com.company.functionalProgramming.funcInterfaceImplementing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

/*
    Примеры реализации функционального интерфейса Supplier<T>
 */
public class SupplierImplementing {

    public static void main(String[] args) {
        Supplier<LocalDate> dateSupplier1 = LocalDate::now;
        Supplier<LocalDate> dateSupplier2 = () -> LocalDate.now();

        LocalDate date1 = dateSupplier1.get();
        LocalDate date2 = dateSupplier2.get();
        System.out.println(date1);
        System.out.println(date2);
        System.out.println("--------------");

        Supplier<StringBuilder> builderSupplier1 = StringBuilder::new;
        Supplier<StringBuilder> builderSupplier2 = () -> new StringBuilder("2");
        System.out.println(builderSupplier1.get());
        System.out.println(builderSupplier2.get());
        System.out.println("--------------");

        Supplier<ArrayList<String>> listSupplier1 = ArrayList<String>::new;
        Supplier<ArrayList<String>> listSupplier2 = () -> new ArrayList<>();
        System.out.println(listSupplier1.get());
        System.out.println(listSupplier2.get());
        System.out.println("--------------");
    }
}
