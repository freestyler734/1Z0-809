package com.company.concurrency.managingConcurrentProcess.forkJoinFramework;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample {

    private static class WeightAnimalAction extends RecursiveAction {
        private int start;
        private int end;
        private double[] weights;

        public WeightAnimalAction(int start, int end, double[] weights) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected void compute() {
            // предполагается, что в рамках одной задачи можно превести не больше 3-х взвешиваний животных
            if (end - start <= 3) {
                for (int i = start; i < end; i++){
                    weights[i] = new Random().nextInt(100);
                    System.out.println("Animal weighted: " + i);
                }
            } else {
                int middle = start + ((end - start)/2);
                System.out.println("[start="+start+", middle="+middle+", end="+end+"]");
                invokeAll(new WeightAnimalAction(start, middle, weights),
                          new WeightAnimalAction(middle, end, weights));
            }
        }
    }

    public static void main(String[] args) {
        double[] weights = new double[10];
        ForkJoinTask<?> task = new WeightAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println();
        System.out.println("Weights:");
        for (double d: weights) System.out.print(d + ", ");
    }
}
