package com.company.concurrency.threads;

public class ThreadExamples {

    private static int counter = 0;

    // Примеры создания потока и выполнения в нем задач

    // 1 способ. Расширить Thread и реализовать метод run
    // (редко используется)
    static class Thread1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread 1 start");
        // 1 способ. Запускаем поток
        new Thread1().start(); // start() - запуск потока

        System.out.println("Thread 2 start");
        // 2 способ. Передать в конструктор Thread задачу
        new Thread(() -> System.out.println("thread 2 action")).start(); // start() - запуск потока
        Thread.sleep(1000);
        System.out.println("------------------------");


        /// Вызов метода run не запускает новый поток, а просто последовательно выполняет код "задач"
        System.out.println("Thread 1 start");
        new Thread1().run();
        System.out.println("Thread 2 start");
        new Thread( () -> System.out.println("thread 2 action")).run();
        System.out.println("------------------------");


        /// Примеры использования Thread.sleep(); - тормозит вызывающий поток на указанное кол-во времени ///
        new Thread(() -> {
            for (int i = 0; i < 500; i ++) {
                counter ++;
            }
        }).start();
        // главный поток проверяет пока дочерний не выполнит работу
        while (counter != 500) {
            System.out.println("Not reached yet");
            Thread.sleep(10); // тормозим поток, для экономия ресурсов CPU (меньше раз будет проверять и печатать в консоль)
        }
        System.out.println("Reached!!!");

    }
}
