package interview.linkedin;

public class Power {
    /**
     * Returns a^b, as the standard mathematical exponentiation function
     * @return 
     */
	/*
    public double power2(double a, int b) {
        int pow = b;
        if (b < 0){
            pow = -b;
        } 
        
        //pow will be non-negative
        
        double retval;
        if (pow == 0) {
            retval = 1;
        } else if (pow == 1) {
            retval = a;
        } else {
            //distinguish among powers of 2 and non-powers
            int pow2 = pow(2,ceil(log(pow,2));
            double prod  = 1;
            prod  = a;
            for (int i = 1; i <= log(pow2,2); i++){
                prod = prod * prod;
            }               
            retval = prod * power(a,pow - pow2);                
        }    
        
        if (b < 0){
            return 1/retval;
        } else {
            return retval;
        }
    }
    */

    public static double power(double a, int n) {
    	double result = -1;
    	double term = a;
    	
    	if ((n & 1) == 1){
    		//last bit is 1
    		result = a;
    	} else {
    		//last bit is 0
    		result = 1;
    	}
    	
    	while ((n = (n >> 1)) != 0) {
            boolean odd = ((n & 1) == 1);
        	
    		term = term * term;
    		if (odd)
    			result = result * term;
    	}
    	
    	return result;
    }
    
    //
    // BEST solution (right to left exponentiation)
    // Discussion on pg 234 of Anany Levitin
    //
    public static double power2(double a, int n) {
    	double result = 1;
    	double term = a;
    	
    	while (n != 0) {
            boolean odd = ((n & 1) == 1);
        	
    		if (odd)
    			result = result * term;
    		term = term * term;
            n = (n >> 1);
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		System.out.println(power(2,0));
		System.out.println(power(2,10));
        
		System.out.println(power2(2,0));
		System.out.println(power2(2,10));
	}
}