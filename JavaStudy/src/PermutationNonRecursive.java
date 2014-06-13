
public class PermutationNonRecursive {

	static int factorial(int n)
	{
	    if (n == 1) return 1;
	    return n * factorial(n-1);
	}

	static void swap(StringBuffer s2, int i, int j) 
	{
	    char c = s2.charAt(i);
	    s2.setCharAt(i, s2.charAt(j));
	    s2.setCharAt(j, c);
	}

	static void permutation(StringBuffer s) 
	{
	    int n = s.length();
	    for (int k = 0; k < factorial(n); k++) {
//	        StringBuffer s = new StringBuffer(s2);
	        for(int j = 1; j < n; ++j) 
	        {
	            swap(s, k % (j + 1), j); 
	            k = k / (j + 1);
	        }
            System.out.println(s);
	    }
	}

    static int count = 0;
    // 0 to suffixIndex - 1 is prefix
    // suffixIndex to the end is suffix
    //TODO make lexicographic
	static void permutationRecursive(StringBuffer str, int suffixIndex) {
		if (str.length() == suffixIndex){
            count++;
			System.out.println(count + ": " + str);
			return;
		}
        
		for (int i = suffixIndex; i < str.length(); i++) {
            if (i != suffixIndex){
            	//dont swap same chars
            	if (str.charAt(suffixIndex) == str.charAt(i))
            		continue;
                
            	// if ith char in suffix already occurs before it in the string, then continue
            	// else we will get duplicate permutations.
            	//e.g. "" "app"
            	//no need to swap a and 2nd p as it is already swapped
            	if (str.charAt(i-1) == str.charAt(i))
            		continue;
            }
            
            swap(str, suffixIndex, i);
			permutationRecursive(str, suffixIndex + 1);
            swap(str, suffixIndex, i);
		}
	}
    
	public static void main(String[] args) {
//	    {StringBuffer s = new StringBuffer("aple"); permutation(s);}
//	    {permutationRecursive(new StringBuffer(""), new StringBuffer("app"));}
//	    {permutationRecursive(new StringBuffer(""), new StringBuffer("appp"));}
//	    {permutationRecursive(new StringBuffer(""), new StringBuffer("alpp"));}
//	    {permutationRecursive(new StringBuffer(""), new StringBuffer("aadmm"));}
	    {permutationRecursive(new StringBuffer("aabbcc"), 0);}

	}
}