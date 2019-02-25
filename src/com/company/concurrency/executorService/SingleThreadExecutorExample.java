package com.company.concurrency.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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


    /// Пример, показывающий что после вызова остановки и ///
    /// прерывания исполняющихся задач (shutdownNow), ///
    /// задачи дейчтвительно прерывают исполнение и метод возвращает список задач которые не начали свое исполнение ///
    public static void shutdownNowExample1() {
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        System.out.println("begin");
        singleThread.execute( () -> System.out.println("first task"));
        singleThread.execute( () -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("second task: " + i);
            }
        });
        singleThread.execute( () -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("third task: " + i);
            }
        });
        singleThread.execute( () -> System.out.println("forth task"));
        List<Runnable> runnables = singleThread.shutdownNow();
        System.out.println("hadn't been started count: " + runnables.size());
        System.out.println("end");
    }


    /// Пример использования метода Future<V> submit(Runnable r) ///
    /// работает как execute, но возвращает объект Future, описывающий переданную задачу. ///
    /// Обобщенный тип - рез-т возвращаемый задачай(Runnable - void, Callable - возвращает), ///
    /// поэтому для Runnable - null ///
    public static void submitExample1() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            Future result = service.submit( () -> {
               for (int i = 0; i < 500; i++) {
                   System.out.println("task: " + i);
               }
            });

            //System.out.println(result.cancel(false));
            System.out.println(result.isDone());
            System.out.println(result.isCancelled());

            // ! МЕТОДЫ GET У FUTURE, ОСТАНАВЛИВАЮТ ГЛАВНЫЙ ПОТОК, ДОЖИДАЯСЬ ЗАВЕРШЕНИЯ ЗАДАЧИ
            //получение результата, ожидание 1 секунду, если за время результата не дожались, то TimeoutException
            //System.out.println(result.get(1, TimeUnit.NANOSECONDS));
            System.out.println(result.get());  // перегрузка без таймаута
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }


    /// Пример использования метода Future<V> submit(Callable c) ///
    public static void submitExample2() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future result = service.submit( () -> 31 + 10 );

            System.out.println(result.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }


    /// Пример использования <T> List<Future<T>> invokeAll(Collection<Callable<T>>)
    /// метод ПОСЛЕДОВАТЕЛЬНО исполняет задачи из переданной коллекции, и возврвщвет List с Future задач в поредке переданной коллекции,
    /// при этом метод работает СИНХРОННО, т.е. пока результат не будет готов для всех задач(м.б. отмена или исключение),
    /// управление не переходит в главный поток. Ожидание м.б. бесконечно, поэтому есть версия метода, где указывается время ожидания
    public static void invokeAllExample1() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            List<Callable<String>> callables = new ArrayList<>();
            for (int i = 1; i < 4; i++ ) {
                int finalI = i;
                callables.add( () -> {
                    String res = "task " + finalI;
                    for (int j = 0; j < 100; j ++) {
                        System.out.println(res + ": " + j);
                    }
                    return res;
                } );
            }
            System.out.println("begin");
            //List<Future<String>> futures = service.invokeAll(callables);
            List<Future<String>> futures = service.invokeAll(callables, 1, TimeUnit.NANOSECONDS);
            for (int i = 0 ; i < futures.size(); i++) {
                System.out.println(futures.get(i).isDone());
            }
            System.out.println("end");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }


    /// Пример использования <T> T invokeAny(Collection<Callable<T>>)
    /// метод ПОСЛЕДОВАТЕЛЬНО исполняет задачи из переданной коллекции, и возврвщвет результат Callable одной завершившейся задач.
    /// Чаще всего это первая переданная задача, но это не гаратированно
    /// Метод работает СИНХРОННО, т.е. пока результат не будет готов одной задачи (м.б. отмена или исключение),
    /// управление не переходит в главный поток. Ожидание м.б. бесконечно, поэтому есть версия метода, где указывается время ожидания
    public static void invokeAnyExample() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            List<Callable<String>> callables = new ArrayList<>();
            for (int i = 1; i <= 3; i++ ) {
                int finalI = i;
                callables.add( () -> {
                    String res = "task " + finalI;
                    for (int j = 1; j <= 10; j ++) {
                        System.out.println(res + ": " + j);
                    }

                    return res;
                } );
            }
            System.out.println("begin");
            String anyResult = service.invokeAny(callables);

            System.out.println("anyResult: " + anyResult);

            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }


    // Пример использования метода awaitTermination(long time, TimeUnit unit).
    // Где time - МАКСИМАЛЬНОЕ время ожидания завершения потока
    // Метод ожидает завершение исполнения потока => его можно вызывать только полсе shutdown()/shutdownNow()
    // Если поток завершился раньше указанного времени, то ожидание вызывающим потоком снимается.
    // Если времени не хватило, то вызывающий поток продолжает свое исполнение
    public static void awaitTerminatoionExample1() {
        ExecutorService service = null;
        System.out.println("begin");
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("before submitting task");
            service.submit( () -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("task: " + i);
                }
            });
            System.out.println("after submitting task");
        } finally {
            if (service != null) service.shutdown();
        }

        if (service != null) {
            try {
                // Ожидание завершения потока, указанное кол-во времени
                // Времени ожидания может нехватить, тогда потоки просто продолжают свою работу.
                // Если потоки завершат работу раньше, то вызывающий поток прекращает ожидание
                service.awaitTermination(4, TimeUnit.SECONDS);

                if (service.isTerminated()) {
                    System.out.println("Task has been completed");
                } else {
                    System.out.println("Task is still Running");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("end");
    }


    public static void main(String[] args) {

        /// Пример рекомендуемого использовая SingleThreadExecutor ///
        // rightSingleThreadUsage();


        /// Пример, показывающий что после вызова остановки (shutdown),///
        /// пока выполняются переданные ранее задачи, ///
        /// если передать потоку новую задачу, то RejectedExecutionException ///
        // shutdownExample1();


        /// Пример, показывающий что после вызова остановки и ///
        /// прерывания исполняющихся задач (shutdownNow), ///
        /// задачи дейчтвительно прерывают исполнение и метод возвращает список задач которые не начали свое исполнение ///
        // shutdownNowExample1();


        /// Пример использования метода Future<V> submit(Runnable r) ///
        /// работает как execute, но возвращает объект Future, описывающий переданную задачу. ///
        /// Обобщенный тип - рез-т возвращаемый задачай(Runnable - void, Callable - возвращает), ///
        /// поэтому для Runnable - null ///
        // submitExample1();


        /// Пример использования метода Future<V> submit(Callable c) ///
        // submitExample2();


        /// Пример использования <T> List<Future<T>> invokeAll(Collection<Callable<T>>)
        /// метод ПОСЛЕДОВАТЕЛЬНО исполняет задачи из переданной коллекции, и возврвщвет List с Future задач в поредке переданной коллекции,
        /// при этом метод работает СИНХРОННО, т.е. пока результат не будет готов для всех задач(м.б. отмена или исключение),
        /// управление не переходит в главный поток. Ожидание м.б. бесконечно, поэтому есть версия метода, где указывается время ожидания
        // invokeAllExample1();


        /// Пример использования <T> T invokeAny(Collection<Callable<T>>)
        /// метод ПОСЛЕДОВАТЕЛЬНО исполняет задачи из переданной коллекции, и возврвщвет результат Callable одной завершившейся задач.
        /// Чаще всего это первая переданная задача, но это не гаратированно
        /// Метод работает СИНХРОННО, т.е. пока результат не будет готов одной задачи (м.б. отмена или исключение),
        /// управление не переходит в главный поток. Ожидание м.б. бесконечно, поэтому есть версия метода, где указывается время ожидания
        // invokeAnyExample();


        // Пример использования метода awaitTermination(long time, TimeUnit unit).
        // Где time - МАКСИМАЛЬНОЕ время ожидания завершения потока
        // Метод ожидает завершение исполнения потока => его можно вызывать только полсе shutdown()/shutdownNow()
        // Если поток завершился раньше указанного времени, то ожидание вызывающим потоком снимается.
        // Если времени не хватило, то вызывающий поток продолжает свое исполнение
        awaitTerminatoionExample1();
    }
}
