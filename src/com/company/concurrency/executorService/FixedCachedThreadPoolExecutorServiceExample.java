package com.company.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
    Пример использования ExecutorService FixedCachedThreadPool(int nThreads), где nThreads - количество
    Данный вид экзекьютора создает пул с указанным кол-м потоков и исполняет задачи в этих потоках.
    Если задач больше чем потоков, то задачи ожидают исполнения в очереди и исполняются в первом освободившемся потоке.
    Если указать кол-во потоков = 1, то сервис превращается в singleThreadExecutor.
*/
public class FixedCachedThreadPoolExecutorServiceExample {

    public static void executeAtFixedCachedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute( ()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("first task: " + i);
            }
        });

        service.execute( ()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("second task: " + i);
            }
        });

        service.execute( ()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("third task: " + i);
            }
        });

        service.execute( ()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("forth task: " + i);
            }
        });

        // service.shutdown();
        service.shutdownNow();
    }

    public static void main(String[] args) {
        executeAtFixedCachedThreadPool();
    }
}
