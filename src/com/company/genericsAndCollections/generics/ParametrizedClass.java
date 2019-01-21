package com.company.genericsAndCollections.generics;

public class ParametrizedClass <T, U> {

    private T object1;
    private U object2;

    ParametrizedClass(){}

    ParametrizedClass(T o1, U o2) {
        this.object1 = o1;
        this.object2 = o2;
    }

    public void setObject1(T o1) {
        this.object1 = o1;
    }

    public void setObject2(U o2) {
        this.object2 = o2;
    }

    public T getObject1() {
        return this.object1;
    }

    public U getObject2() {
        return this.object2;
    }
}
