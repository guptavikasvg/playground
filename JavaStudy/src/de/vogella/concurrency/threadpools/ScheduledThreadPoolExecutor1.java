package de.vogella.concurrency.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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