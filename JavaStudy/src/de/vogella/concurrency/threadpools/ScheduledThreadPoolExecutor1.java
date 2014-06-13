package de.vogella.concurrency.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
  private final long countUntil;

  MyRunnable(long countUntil) {
    this.countUntil = countUntil;
  }

  @Override
  public void run() {
    long sum = 0;
    for (long i = 1; i < countUntil; i++) {
      sum += i;
    }
    System.out.println(sum);
  }
} 
public class ScheduledThreadPoolExecutor1{
  public static void main(String[] args) throws InterruptedException {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      Runnable worker = new MyRunnable(10000000L );
      executor.scheduleAtFixedRate(worker, 0,2, TimeUnit.SECONDS);
      Thread.sleep(5000);
      executor.shutdown();
      while (!executor.isTerminated()) {

     }
    System.out.println("Finished all threads");
  }
} 