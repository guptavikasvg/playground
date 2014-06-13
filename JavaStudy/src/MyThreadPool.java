import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.jmx.snmp.tasks.Task;

class MyThread implements Runnable {

	private volatile Task t;
	private volatile boolean abort;
	private volatile boolean hasWork;
	
    public MyThread(){
    	hasWork = false;
    	abort   = false;
    }
    
	@Override
	public void run() {
        while (true) {
    		synchronized(this){
    			while (!hasWork() && !isAbort()){
                    if (abort)
                    	break;
    				wait();
    			}
    		}
            
    		//execute task
            t.execute();
            t = null;
            
            //make this thread free again
            MyThreadPool pool = getPool();
            pool.threadIsFree(this);
            setHasWork(false);
		}
	}
    
	public boolean hasWork(){
		return hasWork && !abort;
	}

	public Task getT() {
		return t;
	}

	public void setT(Task t) {
		this.t = t;
	}

	public boolean isAbort() {
		return abort;
	}

	public void setAbort(boolean abort) {
		this.abort = abort;
	}

	public boolean isHasWork() {
		return hasWork;
	}

	public void setHasWork(boolean hasWork) {
		this.hasWork = hasWork;
	}
}

public class MyThreadPool {

	private static MyThreadPool impl;
	
    private static Object lock = new Object();
    
    MyThread[] threads;
    
    // a single LL of free Thread objects. It gives you an O(1) way of quickly picking up free threads
    // need to synchronize access to this because multiple calls to addTask() will be dequeing from this.
    List<MyThread> freeThreads;
    
    Map<Task, Thread> taskToThreadMap;
    
	public static MyThreadPool getInstance(){
		if (impl != null)
			return impl;
		
		synchronized (lock){
			if (impl != null)
				impl = new MyThreadPool();
			
			return impl;
		}
	}
    
	public MyThreadPool() {
		super();
        
		threads = new MyThread[10];
		//start these threads. threads can be waiting state. we can queue up their task and notify them.
        for (MyThread thread : threads ){
        	thread.run();
        }
		
        freeThreads = new LinkedList<MyThread>();
		//keep a free list
        //initially all threads are in the free list
        for (int i =0; i< threads.length; i++){
        	freeThreads.add(threads[i]);
        }
	}

    int findFreeThreadIndex(){
        synchronized(freeThreads){
        	freeThreads.get(0);
        }
    	
    }

	boolean addTask(Task t){
		// find free thread
		int threadIndex = findFreeThreadIndex();
		
		if (threadIndex == -1) //no free threads
			return false;
        
		MyThread thread = threads[threadIndex];
		
		thread.setT(t);
		//run current task on the free thread
		synchronized(thread){
			thread.notify();
		}
		
		
		// move free off the freeList
		
		// create entry in hashmap
		
	}
	
	boolean cancelTaskNonBlocking(Task t){
		t.cancel(); //TODO implement cancel()
		
		//2 ways of doing this
		//1. - non-blocking
		//2. blocking. return only when canceled. TODO: need to think of this.
	}
    
	public void threadIsFree(MyThread myThread) {
		//add to free list
	}
}
