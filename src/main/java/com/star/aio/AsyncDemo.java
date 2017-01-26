package com.star.aio;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by win7 on 2017/1/26.
 */
public class AsyncDemo {

    private static void doSomeTask() {
        System.out.println("Hello World");
    }

    private static void onCompletion() {
        System.out.println("All tasks finished");
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(2);

        executorService.execute(new Task(latch));
        executorService.execute(new Task(latch));

        executorService.execute(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onCompletion();
        });


        executorService.shutdown();
    }

    private static class Task implements Runnable {

        private final CountDownLatch latch;

        private Task(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                doSomeTask();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        }
    }
}
