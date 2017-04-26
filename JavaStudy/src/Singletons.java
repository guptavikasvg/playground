class EagerSingleton {
    private static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
        //initialize the object
    }
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

class LazySingleton {
    private static LazySingleton instance;

    //lazy creation of object only when required
    public synchronized static LazySingleton getInstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;

    }
    private LazySingleton() {
        //initialize the object
    }
}

class SingletonDoubleCheckedLocking {
    private volatile static SingletonDoubleCheckedLocking instance; // CAUTION: if you miss volatile, double checked locking is broken.

    //lazy creation of object only when required
    public static SingletonDoubleCheckedLocking getInstance(){
    	// we optimize the frequent case by preventing execution of synchronized block which can be slow.
    	if (instance != null)
    		return instance; 	
    	
    	synchronized(SingletonDoubleCheckedLocking.class){ //Should we prefer to use an internal private lock object?
    		if (instance == null) { // check here because two threads can be waiting at the synchronized block waiting to get in.
				instance = new SingletonDoubleCheckedLocking();
			}
    	}
    	return instance;
    }

    private SingletonDoubleCheckedLocking() {
        //initialize the object
    }
}

enum EnumSingleton {
    INSTANCE; //TODO is this approach eager/lazy? When is INSTANCE created? At startup/first use?
              //will be created when enum is initialized


    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    EnumSingleton() { //no need to write private. Compiler will make it private if no access modifier is specified
        //initialize the object
    }
}