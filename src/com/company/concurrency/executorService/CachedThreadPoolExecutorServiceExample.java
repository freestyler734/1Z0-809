package com.company.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
    Пример использования ExecutorService CachedThreadPool.
    Данный вид экзекьютора создает новый поток каждый по необходимости (если другие заняты)
    и исполняет в них задачу. Т.о. все переданные задачи выполняются параллельно.
    Хорошо подходит для небольших задач. Для продолжительных использование не рекомендуется,
    потому что для продолжитльных будет создавать много потоков.
*/
public class CachedThreadPoolExecutorServiceExample {

    public static void executeAtThreadPoolExaple() {
        ExecutorService service = Executors.newCachedThreadPool();
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

        //service.shutdown();
        service.shutdownNow();
    }


    public static void main(String[] args) {
        executeAtThreadPoolExaple();
    }
}
