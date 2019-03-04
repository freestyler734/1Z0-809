package com.company.concurrency.managingConcurrentProcess;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    private void performTask(CyclicBarrier c) {
        try {
            removeAnimals();
            c.await();
            cleanPen();
            c.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierExample barrierExample = new CyclicBarrierExample();

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(8);
            // Два конструктора CyclicBarrier.
            // Первый параметр - кол-во вызовов await, после которого барьер разблокируется
            // Второй параметр(необязательный) - Runnable, которая выполняется после разблокировки барьера.
            // После того как барьер разблокирован(вызвано указанное кол-во методов), барьер снова активен,
            // и чтобы его разблокировать необходимо снова вызвать указанное кол-во раз метод await,
            // В противном случае получили deadlock. Поэтому называется CYCLIC barrier.
            // Также поэтому барьер можно переиспользовать в другом месте,
            // где используется указанное кол-во потоков.
            CyclicBarrier barrier1 = new CyclicBarrier(4);
            CyclicBarrier barrier2 = new CyclicBarrier(8, () -> System.out.println("* Task is completed by all threads"));
            for (int i = 0; i < 8; i++) { //
                service.execute(() -> barrierExample.performTask(barrier2));
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
