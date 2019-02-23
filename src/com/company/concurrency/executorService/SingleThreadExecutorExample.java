package com.company.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    /// Пример рекомендуемого использовая SingleThreadExecutor ///
    public static void rightSingleThreadUsage() {
        ExecutorService singleThread = null;
        try {
            // задачи в потоке выполняются последовательно
            singleThread = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            singleThread.execute( () -> System.out.println("first task"));
            singleThread.execute( () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("second task: " + i);
                }
            });
            singleThread.execute( () -> System.out.println("third task"));
            System.out.println("end");

        } finally {
            // если не выключить executor, то поток будет висеть
            if (singleThread != null) singleThread.shutdown();
        }
    }

    /// Пример, показывающий что после вызова остановки (shutdown),///
    /// пока выполняются переданные ранее задачи, ///
    /// если передать потоку новую задачу, то RejectedExecutionException ///
    public static void shutdownExample1() {
        ExecutorService singleThread = null;
        singleThread = Executors.newSingleThreadExecutor();
        System.out.println("begin");
        singleThread.execute( () -> System.out.println("first task"));
        singleThread.execute( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("second task: " + i);
            }
        });
        singleThread.shutdown();
        singleThread.execute( () -> System.out.println("third task"));
        System.out.println("end");
    }

    public static void main(String[] args) {

        /// Пример рекомендуемого использовая SingleThreadExecutor ///
        rightSingleThreadUsage();

        /// Пример, показывающий что после вызова остановки (shutdown),///
        /// пока выполняются переданные ранее задачи, ///
        /// если передать потоку новую задачу, то RejectedExecutionException ///
        shutdownExample1();
    }
}
