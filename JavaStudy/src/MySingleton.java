
public class MySingleton {

    private static MySingleton instance;
    
    public static MySingleton getInstance(){
    	// we optimize the frequent case by preventing execution of synchronized block which can be slow.
    	// 
    	if (instance != null)
    		return instance; 	
    	
    	synchronized(MySingleton.class){
    		if (instance == null)
    			instance = new MySingleton();    		
    	}
    	return instance;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
