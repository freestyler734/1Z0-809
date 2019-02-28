package com.company.concurrency.synchronizingDataAccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBlockExample {


    static class ConcurrentSynchronizedDataAccess {

        private int count = 0;
        private static int staticCount = 0;

        // равносильно добавлению в сигнатуру метода спецификатора synchronized
        private void incrementAndReport() throws InterruptedException {
            synchronized (this) {
                System.out.print(++count + " ");
                Thread.sleep(5000);
            }
        }

        private synchronized void print() {
            System.out.println("hi");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // равносильно добавлению в сигнатуру метода спецификатора synchronized
        private static void incrementAndReportStatic() {
            // пример синхронизации статического метода
            synchronized (ConcurrentSynchronizedDataAccess.class) {
                System.out.print(++staticCount + " ");
            }
        }

        public void run() {
            ExecutorService service = null;
            try {
                service = Executors.newFixedThreadPool(50);
                for (int i = 0; i < 10; i++) {
                    service.submit(() -> {
                        try {
                            incrementAndReport();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
                service.submit(() -> print());
            } finally {
                if (service != null) service.shutdown();
            }
        }
    }

    public static void main(String[] args) {
        new ConcurrentSynchronizedDataAccess().run();
    }
}
