package com.company.concurrency.callable;


import java.io.IOException;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class CallableExamples {

    static class MyCallable<V> implements Callable<V> {

        private V result;

        MyCallable(V result) {
            this.result = result;
        }

        // Метод позволяет выбрасывать проверяемые исключения
        @Override
        public V call() throws Exception {
            return result;
        }
    }

    public static void use(Callable c) {}
    public static void use(Supplier c) {}

    // Примеры использование интерфейса Callable и отличия от Runnable
    public static void main(String[] args) {

        // Пример 1. Callable, т.к. call возвращает результат, лямбда также должна его возвращать
        Callable<String> callable1 = () -> "task1";
        submitAndPrint(callable1);
        // Пример 2. Callable с помощью реализации интерфейса классом.
        Callable<String> callable2 = new MyCallable<>("task2");
        submitAndPrint(callable2);

        // Т.к. Callable и Supplier интерфейсы имеют идентичную сигнатуру(помимо Exception),
        // при перегрузки методов с параметрами этих интерфейсов, Java не понимает какой метод вызывать
        // поэтому код не компилится - Ambiguous method call. Ситуацию можно разрешить явным приведением типов
        // use( () -> ""); // не компилится
        use((Callable) () -> "");
        use((Supplier) () -> "");

        use((Callable) () -> {throw new IOException();});
       // use((Supplier) () -> {throw new IOException();}); // сигнатура Supplier не содержит проверяемых исключений.


        // Т.к. submit принимает и Runnable и Callable,
        // то в случае, когда в задаче используется код выбрасывающий проверяемое исключение,
        // нужно обязательно указывать возвращаемое значение в лямбде, т.к. Runnable не поддерживает проверяемые исключения
        // и без try-catch не скомпилися.
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // service.submit( () -> { Thread.sleep(12); } ); без try-catch не компилится
            service.submit( () -> { Thread.sleep(12); return null; } );
        } finally {
            if (service != null) service.shutdown();
        }


    }

    public static void submitAndPrint(Callable<?> callable) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(callable);
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public static String method() throws IOException {
        throw new IOException();
    }
}
