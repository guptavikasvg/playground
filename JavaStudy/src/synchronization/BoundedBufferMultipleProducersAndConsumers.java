package synchronization;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread{
	
    BoundedBufferMultipleProducersAndConsumers q;
    
	public Producer(BoundedBufferMultipleProducersAndConsumers q) {
		super();
		this.q = q;
	}

	public void run() {
        while(true){
        	try {
                q.put(Math.random());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}

class Consumer extends Thread{
	
    BoundedBufferMultipleProducersAndConsumers q;
    
	public Consumer(BoundedBufferMultipleProducersAndConsumers q) {
		super();
		this.q = q;
	}
	public void run() {
        while(true){
        	try {
				System.out.println(q.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}

public class BoundedBufferMultipleProducersAndConsumers {

	BlockingQueue queue;
	
	public BoundedBufferMultipleProducersAndConsumers() {
		super();
		queue = new ArrayBlockingQueue(2);
	}
	
    void put(Object o) throws InterruptedException{
		queue.put(o);
    }
    
    Object get() throws InterruptedException{
        return queue.take();
    }
    
	public static void main(String[] args) {        
        BoundedBufferMultipleProducersAndConsumers q = new BoundedBufferMultipleProducersAndConsumers();
        (new Producer(q)).start();
        (new Producer(q)).start();
        (new Consumer(q)).start();
        (new Consumer(q)).start();
	}

}
