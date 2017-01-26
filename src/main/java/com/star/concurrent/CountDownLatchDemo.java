package com.star.concurrent;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

	private static CountDownLatch countDownLatch = new CountDownLatch(4);

	private static ExecutorService executor = Executors.newFixedThreadPool(4);

	private static int THREAD_COUNT = 4;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < THREAD_COUNT; i++) {

			executor.execute(new Runnable() {

				public void run() {

					try {

						// 模拟业务逻辑的耗时

						int timer = new Random().nextInt(5);

						TimeUnit.SECONDS.sleep(timer);

						System.out.printf("%s时完成磁盘的统计任务,耗费%d秒.\n", new Date().toString(), timer);

						// 业务处理完成之后,计数器减一

						countDownLatch.countDown();

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

				}

			});

		}
		countDownLatch.await();
		System.out.printf("%s时全部任务都完成,执行合并计算.\n", new Date().toString());
		executor.shutdown();
	}

}
