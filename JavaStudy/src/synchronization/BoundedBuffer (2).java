package synchronization;

import java.util.Vector;

//Bounded Buffer using monitors
// Can be solved in a better way by simply using n producers, n consumers and 1 ArrayBlockingQueue

public class BoundedBuffer {

    public BoundedBuffer(){
        Thread producer = new Thread() {
			public void run() {
                produce();
			}
		};
        producer.start();
        Thread consumer = new Thread() {
            public void run() {
                consume();
            }
        };
        consumer.start();
    }
    
    Object bufferIsNotEmpty = new Object();
    Object bufferIsNotFull  = new Object();

    Vector buffer = new Vector();
    static int counter = 0;

    boolean isFull() {
        synchronized(buffer) {
            return buffer.size() == 2;
        }
    }

    boolean isEmpty() {
        synchronized(buffer) {
            return buffer.size() == 0;
        }
    }

    void produce() {
        while (true) {
            // produce till the buffer is full
            while (isFull()) {
                synchronized(bufferIsNotFull) {
                    try {
						bufferIsNotFull.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
            
            // It is possible that buffer is full again at this point. Producer can get preempted out at this point. A different consumer can run again and fill up the buffer
            // So, we should check one more time if buffer is not full, only then add the item. else just go back to waiting. It seems fine for 1 producer and 1 consumer case though
            synchronized(buffer) {
            	counter++;
                System.out.println("Added " + counter);
                buffer.add(new Integer(counter));
            }

            synchronized(bufferIsNotEmpty){
                bufferIsNotEmpty.notify();
            }
        } 
    }

    void consume() {
        while (true) {
            // produce till the buffer is full
            while (isEmpty()) {
                synchronized(bufferIsNotEmpty) {
                    try {
						bufferIsNotEmpty.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
            
            synchronized(buffer) {
                Integer i = (Integer) buffer.remove(0);
                System.out.println("Removed " + i);
            }

            synchronized(bufferIsNotFull){
            	bufferIsNotFull.notify();
            }
        } 
    }

    public static void main(String [] args) {
        new BoundedBuffer();
    }
}

