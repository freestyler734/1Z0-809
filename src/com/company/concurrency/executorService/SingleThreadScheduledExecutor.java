package com.company.concurrency.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {

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

            System.out.println("delay: " + result.getDelay(TimeUnit.SECONDS));

            System.out.println("after task scheduling");
        } finally {
            if (service != null) service.shutdown();
        }
    }


    public static void main(String[] args) {
        // Пример использования метода ScheduledFuture schedule(Runnable r, long time, TimeUnit unit) интрефейса ScheduledExecutorService
        // Метод выполняет команду через переданное время.
        scheduleRunnable();
    }
}
