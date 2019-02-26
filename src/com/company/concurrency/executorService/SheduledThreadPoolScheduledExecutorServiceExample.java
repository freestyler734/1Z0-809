package com.company.concurrency.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/*
    Пример использования ScheduledExecutorService ScheduledThreadPool(int nThreads), где nThreads - количество
    Данный вид экзекьютора создает пул с указанным кол-м потоков и исполняет задачи в этих потоках.
    Если задач больше чем потоков, то задачи ожидают исполнения в очереди и исполняются в первом освободившемся потоке.
    Если указать кол-во потоков = 1, то сервис превращается в singleScheduledThreadExecutor.
    Данный экзекьютор то же самое, что и FixedCachedThreadPool, но позволяет планировать задачи.
*/
public class SheduledThreadPoolScheduledExecutorServiceExample {

    public static void scheduleAtScheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        service.scheduleWithFixedDelay( () -> System.out.println("first task"), 1, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay( () -> System.out.println("second task"), 1, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay( () -> System.out.println("third task"), 1, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay( () -> System.out.println("forth task"), 1, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay( () -> System.out.println("fifth task"), 1, 1, TimeUnit.SECONDS);

        //service.shutdown();
    }

    public static void main(String[] args) {
        scheduleAtScheduledThreadPool();
    }
}
