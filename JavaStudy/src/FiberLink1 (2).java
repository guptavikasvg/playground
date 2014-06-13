import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Comp implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        
        assert s1.length() > 0;
        assert s2.length() > 0;
        
        if (s1 == null || s2 == null)
        	return 0;
        
        /*
        if (s1 == null){
        	//s2 is not null
        	
        } else if (s2 == null){
        	
        }
        */
        return s1.length() - s2.length();
	}
}

public class FiberLink1 {

    public static void main(String args[]){
    	List <String> list = Arrays.asList(args);
    	
    	Comparator com = new Comp();
    	Collections.sort(list, com);
    }
}
