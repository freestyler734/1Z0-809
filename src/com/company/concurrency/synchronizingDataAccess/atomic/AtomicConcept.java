package com.company.concurrency.synchronizingDataAccess.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicConcept {

    /*
        Пример демонстрирующий проблему доступа одновоременного чтения/записи данных несколькими потоками.
        Проблеме состоит в том, что в задачах с доступом ко одним данным, некоторые из потоков отрабатывают быстрее,
        хотя начали исполнение позже, и может возникнуть ситуация,
        что потоки одновременно считали значение и оба обновляют это считанное значение, и обновление одного из них теряется,
        т.к. он пытается обновить неактуальные данные.
        Реальный пример вывода - 1 1 2 3 4 5 6 7 8 9. Хоть случается не часто но проблема есть
     */
    static class ConcurrentDataAccessProblem {

        private int count = 0;

        private void incrementAndReport() {
            System.out.print(++count + " ");
        }

        public void run() {
            ExecutorService service = null;
            try {
                service = Executors.newFixedThreadPool(50);
                for (int i = 0; i < 10; i++) {
                    service.submit( () -> incrementAndReport());
                }

            } finally {
                if (service != null) service.shutdown();
            }
        }
    }

    /*
        Решение проблемы - использования java.util.concurrent.atomic.* Классы
        Классы предоставляют методы для записи/чтения как одной операции, не позволяя получить доступ к данным,
        пока поток выполняет свою операцию. Т.о. не м.б. ситуации, когда 2 потока одновременно считали данные и изменили,
        т.к. чтение запись - одна операция.
     */
    static class ConcurrentDataAccessWithAtomic {

        private AtomicInteger count = new AtomicInteger(0);

        private void incrementAndReport() {
            System.out.print(count.incrementAndGet() + " ");
        }

        public void run() {
            ExecutorService service = null;
            try {
                service = Executors.newFixedThreadPool(50);
                for (int i = 0; i < 10; i++) {
                    service.submit( () -> incrementAndReport());
                }
            } finally {
                if (service != null) service.shutdown();
            }
        }
    }

    public static void main(String[] args) {
//        Пример демонстрирующий проблему доступа одновоременного чтения/записи данных несколькими потоками.
//        Проблеме состоит в том, что в задачах с доступом ко одним данным, некоторые из потоков отрабатывают быстрее,
//        хотя начали исполнение позже, и может возникнуть ситуация,
//        что потоки одновременно считали значение и оба обновляют это считанное значение, и обновление одного из них теряется,
//        т.к. он пытается обновить неактуальные данные.
//        Реальный пример вывода - 1 1 2 3 4 5 6 7 8 9. Хоть случается не часто но проблема есть
        //new ConcurrentDataAccessProblem().run();


//        Решение проблемы - использования java.util.concurrent.atomic.* Классы
//        Классы предоставляют методы для записи/чтения как одной операции, не позволяя получить доступ к данным,
//        пока поток выполняет свою операцию. Т.о. не м.б. ситуации, когда 2 потока одновременно считали данные и изменили,
//        т.к. чтение запись - одна операция.
        new ConcurrentDataAccessWithAtomic().run();

    }
}
