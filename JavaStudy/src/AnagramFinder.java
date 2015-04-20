import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnagramFinder {

    class Signature {
        String sig;
    	Signature(String word){
    		//sort the letters in the string
    		char[] chars = word.toCharArray();
    		Arrays.sort(chars);
    		sig = new String(chars);
    	}
        
    	boolean equals(Signature sig2){
    		return sig.equals(sig2.sig);
    	}
    }
    
    class WordSig {
    	String word;
    	Signature sig;
    
    	WordSig(String word) {
    		this.word = word;
    		this.sig = new Signature(word);
        }	
    }
    
    //compares word according to their signatures
    class SignatureComp implements Comparator{
		@Override
		public int compare(Object arg0, Object arg1) {
            String o1 = ((WordSig) arg0).sig.sig;
            String o2 = ((WordSig) arg1).sig.sig;
            return o1.compareTo(o2);
		}
    }

    void insertIntoRetval(List retval, List words, int start, int end) {
        List output = new ArrayList();
        for (int i = start; i <= end; i++){
        	output.add(((WordSig)words.get(i)).word);
        }
        retval.add(output);
    }
    
    List computeAnagrams(List input){
    	//array of WordSig
    	ArrayList words = new ArrayList();
    	
    	List retval = new ArrayList();
    
    	if (input.size() <= 0)
    		return retval;
    
    	for(int i = 0; i < input.size(); i++){
    		WordSig ws = new WordSig((String) input.get(i));
            words.add(ws);
        }
    
    	Collections.sort(words, new SignatureComp());
    
        Signature oldSig = ((WordSig)words.get(0)).sig;
        Signature currentSig = null;
        int startOfAnagramSet = 0;
        for (int i = 1; i < words.size(); i++) {
            currentSig = ((WordSig)words.get(i)).sig;
    
            if (!oldSig.equals(currentSig)) {
                //found a new set of anagrams from startOfAnagramSet till i - 1
                //copy over the current set to the retval
                insertIntoRetval(retval, words,startOfAnagramSet, i - 1);
                
                //start a new set of anagrams
                oldSig = currentSig;
                startOfAnagramSet = i;
            }
        }
            
        insertIntoRetval(retval, words, startOfAnagramSet, words.size() - 1);
        return retval;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String[] words = {"ape", "pae", "apple", "leppa", "epa"};
        List anagrams = new AnagramFinder().computeAnagrams(Arrays.asList(words));
        System.out.println(anagrams);
        
        String[] words2 = {"ape"};
        anagrams = new AnagramFinder().computeAnagrams(Arrays.asList(words2));
        System.out.println(anagrams);
	}

}
