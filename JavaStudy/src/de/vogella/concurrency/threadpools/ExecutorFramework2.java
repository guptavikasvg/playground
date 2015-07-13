package de.vogella.concurrency.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//class MyRunnable2 implements Runnable {
//  private final double countUntil;
//
//  MyRunnable2(double countUntil) {
//    this.countUntil = countUntil;
//  }
//
//  @Override
//  public void run() {
//    double sum = 0;
//    for (double i = 1; i < countUntil; i++) {
//      sum += i;
//    }
//    System.out.println(sum);
//  }
//}

class MyCallable implements Callable<Double>{
    private final double countUntil;

	@Override
	public Double call() throws Exception {
        run();
		return run();
	}

    MyCallable(double countUntil) {
    	this.countUntil = countUntil;
    }

    public Double run() {
    	double sum = 0;
    	for (double i = 1; i < countUntil; i++) {
    		sum += i;
    	}
        return sum;
    }
}

public class ExecutorFramework2{
  public static void main(String[] args) throws InterruptedException {
//    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ExecutorService executor = Executors.newFixedThreadPool(2);
      //Runnable runnable = new MyRunnable2(10000000L * 100L);
      Callable<Double> callable = new MyCallable(10000000L * 100);
      Callable<Double> callable2 = new MyCallable(10000000L );
      
      Future<Double> future = executor.submit(callable);
      Future<Double> future2 = executor.submit(callable2);
      while (true){
          try {
    		Double o = future.get(300, TimeUnit.MILLISECONDS);
            System.out.println("Got result: " + o);
            break;
          }
          catch (ExecutionException e) {
        		e.printStackTrace();
          } catch (TimeoutException e) {
        		e.printStackTrace();
          }
      }
      
      while (true){
          try {
    		Double o = future2.get(10, TimeUnit.MILLISECONDS);
            System.out.println("Got result: " + o);
            break;
          }
          catch (ExecutionException e) {
        		e.printStackTrace();
          } catch (TimeoutException e) {
        		e.printStackTrace();
          }
      }
      executor.shutdown();
  }
} 