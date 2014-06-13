package synchronization;

import java.util.Vector;

//Bounded Buffer using monitors

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

