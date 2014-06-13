package containers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
   int numberOfItemsToProduce;
   private final BlockingQueue queue;
   Producer(BlockingQueue q) { 
	   queue = q; 
   }
   public void run() {
     try {
       while (numberOfItemsToProduce < 10) {
    	   numberOfItemsToProduce++;
    	   System.out.println("Putting in q");
    	   queue.put(produce()); 
    	   
       }
     } catch (InterruptedException ex) { ex.printStackTrace();}
   }
   Object produce() {  return new Object();}
 }

 class Consumer implements Runnable {
   private final BlockingQueue queue;
   Consumer(BlockingQueue q) { queue = q; }
   public void run() {
     try {
       while (true) { 
    	   consume(queue.take());
    	   System.out.println("Consumed from q");
       }
     } catch (InterruptedException ex) { ex.printStackTrace();}
   }
   void consume(Object x) { }
 }

 public class BlockingQueueTest1 {
   public static void main(String[] args) {
     BlockingQueue q = new ArrayBlockingQueue(1);
     Producer p = new Producer(q);
     Consumer c1 = new Consumer(q);
     Consumer c2 = new Consumer(q);
     new Thread(p).start();
     new Thread(c1).start();
     new Thread(c2).start();
   }
 }