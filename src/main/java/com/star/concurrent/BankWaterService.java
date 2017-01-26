package com.star.concurrent;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BankWaterService implements Runnable {

	/**
	 * 
	 * 创建4个屏障,处理完之后,执行当前类的run方法
	 * 
	 */

	private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

	/**
	 * 
	 * 启动4个线程
	 * 
	 */

	private Executor executor = Executors.newFixedThreadPool(4);

	/**
	 * 
	 * 保存每个sheet计算出来的银行交易流水结果
	 * 
	 */

	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

	/**
	 * 
	 * 交易流水统计
	 * 
	 */

	private void count() {

		for (int i = 0; i < 4; i++) {

			executor.execute(new Runnable() {

				public void run() {

					// 模拟计算当前sheet的银行交易流水数据的业务处理

					sheetBankWaterCount.put(Thread.currentThread().getName(), 1);

					// 银行交易流水计算完成后,插入一个屏障

					try {

						cyclicBarrier.await();

					} catch (InterruptedException e) {

						e.printStackTrace();

					} catch (BrokenBarrierException e) {

						e.printStackTrace();

					}

				}

			});

		}

	}

	/**
	 * 
	 * 汇总计算结果
	 * 
	 */

	public void run() {

		int result = 0;

		for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {

			result += sheet.getValue();

		}

		// 设置计算结果,并输出

		sheetBankWaterCount.put("result", result);

		System.out.println(result);

	}

	public static void main(String[] args) {

		BankWaterService service = new BankWaterService();

		service.count();

	}

}
