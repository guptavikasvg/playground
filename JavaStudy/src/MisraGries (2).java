import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MisraGries {

    public static ArrayList<Integer> findRepetedElements(int[] arr, int M) {
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
    		int minCount = (int) Math.ceil(((double) arr.length) / M);
    		
    		for (int i = 0; i < arr.length; i++)
    			add(tm, arr[i], M);
    		
    		// find count of elements left in the tree
    		Iterator<Entry<Integer, Integer>> iter = tm.entrySet().iterator();
    		Entry<Integer, Integer> e;
    		int value;
    		int currCount;
    		while (iter.hasNext()) {
    			currCount = 0;
    			e = iter.next();
    			value = e.getValue();
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] == value)
                        currCount++;
                
                if (currCount >= minCount) {
					result.add(value);
				}
            }
        
        return result;
    }
    
    private static void add(TreeMap<Integer, Integer> tm, Integer key, int maxSize) {
        Integer mpValue = tm.get(key);
        
        if (mpValue == null)
            tm.put(key, 1);
        else
            tm.put(key, mpValue + 1);
        
        if (tm.size() == maxSize)
            clearRow(tm);
    }
    
    private static void clearRow(TreeMap<Integer, Integer> tm) {
        Iterator<Entry<Integer, Integer>> iter = tm.entrySet().iterator();
        
        Entry<Integer, Integer> e;
        int value;
        while (iter.hasNext()) {
            e = iter.next();
            value = e.getValue();
            if (value == 1)
                iter.remove();
            else
                e.setValue(value - 1);
        }
    }

	public static void main(String[] args) {
		int[] array = new int[5];
		array[0]
	}

}
