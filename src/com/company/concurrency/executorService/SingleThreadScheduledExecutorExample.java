package com.company.concurrency.executorService;

import java.util.concurrent.*;

public class SingleThreadScheduledExecutorExample {

    // Пример использования метода ScheduledFuture schedule(Runnable r, long time, TimeUnit unit) интрефейса ScheduledExecutorService
    // Метод выполняет команду через переданное время. Причем если команду планировщик ОС заплпнировал, то она выполнится,
    // несмотря на вызов shutdown(), но shutdownNow() ее отменит
    public static void scheduleRunnable() {
        ScheduledExecutorService service = null;
        try {
            // ScheduledExecutorService интерфейс extends ExecutorService
            // и содержит доп. методы типа schedule
            service = Executors.newSingleThreadScheduledExecutor();
            // запуск Runnable через 2 секунды
            // ScheduledFuture<V> extends Delayed, Future<V>. ScheduledFuture не имеет сових методов,
            // но Delayed, добавляет long getDelay(TimeUnit unit) метод.
            System.out.println("before task scheduling");
            ScheduledFuture result = service.schedule(
                    () -> System.out.println("scheduled Runnble task"),
                    5,
                    TimeUnit.SECONDS);

            System.out.println("after task scheduling");

            Thread.sleep(2000);
            System.out.println("delay: " + result.getDelay(TimeUnit.SECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }


    // Пример использования метода ScheduledFuture schedule(Callable c, long time, TimeUnit unit) интрефейса ScheduledExecutorService
    // Метод выполняет команду через переданное время. Причем если команду планировщик ОС заплпнировал, то она выполнится,
    // несмотря на вызов shutdown(), но shutdownNow() ее отменит
    public static void scheduleCallable() {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();

            System.out.println("before scheduling task");
            ScheduledFuture result = service.schedule( () -> {
                String name = "scheduled Callable task";
                System.out.println(name);
                return name; }, 5, TimeUnit.SECONDS);
            System.out.println("after scheduling task");

            System.out.println("delay: " + result.getDelay(TimeUnit.SECONDS));

        } finally {
            if (service != null) service.shutdown();
        }
    }


    // Пример использования ScheduledFuture scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit)
    // мотод запускает задачу через время initialDelay, и повторяет запуск через period, вне зависимости от результата
    public static void scheduleAtFixedRateExample() {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            System.out.println("before scheduling task");
            ScheduledFuture result = service.scheduleAtFixedRate( () -> System.out.println("task execution"), 1, 2, TimeUnit.SECONDS);
            System.out.println("after scheduling task");

            //System.out.println("result.get(): " + result.get(3, TimeUnit.SECONDS));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
        } finally {
            if (service != null) service.shutdownNow();
        }
    }


    // Пример использования ScheduledFuture scheduleWithFixedDelay(Runnable command,long initialDelay,long period,TimeUnit unit)
    // мотод запускает задачу через время initialDelay, и повторяет запуск через period, ПОСЛЕ завершеня предыдущей задачи
    public static void scheduleWithFixedDelayExample() {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            System.out.println("before scheduling task");
            ScheduledFuture result = service.scheduleWithFixedDelay( () -> System.out.println("task execution"), 1, 2, TimeUnit.SECONDS);
            System.out.println("after scheduling task");

            //System.out.println("result.get(): " + result.get(3, TimeUnit.SECONDS));
           // System.out.println("result.get(): " + result.get());
           // Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
        } finally {
            if (service != null) service.shutdownNow();
        }
    }


    public static void main(String[] args) {

        // Пример использования метода ScheduledFuture schedule(Runnable r, long time, TimeUnit unit) интрефейса ScheduledExecutorService
        // Метод выполняет команду через переданное время. Причем если команду планировщик ОС заплпнировал, то она выполнится,
        // несмотря на вызов shutdown(), но shutdownNow() ее отменит
         scheduleRunnable();


        // Пример использования метода ScheduledFuture schedule(Callable c, long time, TimeUnit unit) интрефейса ScheduledExecutorService
        // Метод выполняет команду через переданное время. Причем если команду планировщик ОС заплпнировал, то она выполнится,
        // несмотря на вызов shutdown(), но shutdownNow() ее отменит
        // scheduleCallable();


        // Пример использования ScheduledFuture scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit)
        // мотод запускает задачу через время initialDelay, и повторяет запуск через period, вне зависимости от результата
        // scheduleAtFixedRateExample();


        // Пример использования ScheduledFuture scheduleWithFixedDelay(Runnable command,long initialDelay,long period,TimeUnit unit)
        // мотод запускает задачу через время initialDelay, и повторяет запуск через period, ПОСЛЕ завершеня предыдущей задачи
        // scheduleWithFixedDelayExample();
    }
}
