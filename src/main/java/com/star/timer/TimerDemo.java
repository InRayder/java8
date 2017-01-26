package com.star.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TimerDemo {

	@Test
	public void givenUsingTimer_whenSchedulingTaskOnce_thenCorrect() {
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println("Task performed on: " + new Date() + "n" + "Thread's name: "
						+ Thread.currentThread().getName());
			}
		};

		Timer timer = new Timer("Timer");
		long delay = 1000L;
		timer.schedule(task, delay);
		
	}
	
	@Test
	public void givenUsingTimer_whenSchedulingRepeatedTask_thenCorrect(){
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    Timer timer = new Timer("Timer");

	    long delay  = 1000L;
	    long period = 1000L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	
	@Test
	public void givenUsingExecutorService_whenSchedulingRepeatedTask_thenCorrect(){
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	    long delay  = 1000L;
	    long period = 1000L;
	    executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
	    try {
			Thread.sleep(delay + period * 3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    executor.shutdown();
	}
}
