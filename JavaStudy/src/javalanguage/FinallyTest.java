package javalanguage;

public class FinallyTest {
    
	static void exitFromTry() {
        try {
            System.exit(-1);
        } catch (Exception e){
        	System.out.println("in catch");
        } finally {
        	System.out.println("in finally");
        }
    	System.out.println("after finally");
	}
	static void returnFromTry() {
        try {
            return;
        } catch (Exception e){
        	System.out.println("in catch");
        } finally {
        	System.out.println("in finally");
        }
    	System.out.println("after finally");
	}

	static void returnFromCatch() {
        try {
        	throw new Exception();
        } catch (Exception e){
        	return ;
        } finally {
        	System.out.println("in finally");
        }
//    	System.out.println("out of finally");
	}
    
	static int returnFromTryAndBreakInFinally() {
    for(;;) {       	   
        try {
   	       return 1;	//should return 1
        } finally {
            break;	   
        }		   
    }		   
    return -1;			//returns -1
	}
    
	static void returnFromTryAndContinueInFinally() {
        int count = 0;
        while (true) {                
            try {                     
				System.out.println(count++);
                return;               //return never happens. Goes into infinite loop
            } finally {               
                continue;             
            }                         
        }                             
        /* NOT REACHED */
//        System.out.println("after while loop"); //compiler error about unreachable code
	}
    
	public static void main(String[] args) {
        //returnFromTry();
        //exitFromTry();
//        System.out.println(returnFromTryAndBreakInFinally());
        returnFromTryAndContinueInFinally();
	}
}