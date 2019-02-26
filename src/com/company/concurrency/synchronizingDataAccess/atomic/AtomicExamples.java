package com.company.concurrency.synchronizingDataAccess.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicExamples {

    static class DataClassExample {
        int age = 0;
        String name = "";

        DataClassExample(){}

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void incrementAge() {
            age++;
        }
    }

    // Все классы, кроме массивов имеют 2 конструктора без параметра и с ссответствующим типом
    // Массивы имеют конструктор с параметром длинна и конструктор с параметром массив
    // AtomicReference и AtomicReferenceArray - обобщенные и содержат объект типа Дженерик.
    private static AtomicInteger atomicInteger;
    private static AtomicBoolean atomicBoolean;
    private static AtomicLong atomicLong;
    private static AtomicReference<DataClassExample> atomicReference;
    private static AtomicIntegerArray atomicIntegerArray;
    private static AtomicLongArray atomicLongArray;
    private static AtomicReferenceArray<DataClassExample> atomicReferenceArray;

    public static void main(String[] args) {

        atomicReference = new AtomicReference(new DataClassExample());
        atomicReference.getAndUpdate( o -> {o.age++; return o; });

        atomicIntegerArray = new AtomicIntegerArray(3);
        atomicIntegerArray.get(0);
        atomicIntegerArray.set(1, 777);
        atomicIntegerArray.getAndAdd(1,5);
        atomicIntegerArray.getAndUpdate(2, (i) -> i*2);

        atomicReferenceArray = new AtomicReferenceArray<DataClassExample>(5);
        atomicReferenceArray.getAndUpdate(4, e -> e);
    }
}
