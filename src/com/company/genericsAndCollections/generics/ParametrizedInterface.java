package com.company.genericsAndCollections.generics;

// обобщенный интерфейс
interface I<T> {
    public void method(T o);
}

// пример 1 реализации обобщенного интерфейса
// c указанием конкретного типа
class A implements I<String> {

    @Override
    public void method(String o) {
        System.out.println(o);
    }
}


// пример 2 реализации обобщенного интерфейса
// с указанием обощенного типа класса
class B<S> implements I<S> {

    @Override
    public void method(S o) {
        System.out.println(o.toString());
    }
}

// пример 3 реализации обобщенного интерфейса
// без указания типа
class C implements I {

    @Override
    public void method(Object o) {
        System.out.println(o.toString());
    }
}


public class ParametrizedInterface {

    public static void main(String[] args) {

        // примеры использования ссылки обощенного интерфейса
        I<String> i1 = new A();
       // I<Integer> i2 = new A(); // не компилится


        I<String> i3 = new B<>();
        I<Integer> i4 = new B<>();
        B<String> b = new B<>();
        // i4 = b; // не компилится
        // I<Integer> i5 = new B<String>(); // не компилится

        // совместим с любым типом т.к. при реализации не указали конкретный тип
        I<String> i6 = new C();
        I<Integer> i7 = new C();
    }
}
