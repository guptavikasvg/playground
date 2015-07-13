package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by vgupta on 4/20/15.
 */
public class HashSet<E> implements Set<E> {

    private final Map<E,E> map;

    public HashSet(int capacity, float loadFactor){
        map = new HashMap(capacity, loadFactor);
    }

    //what should be the return value?
    E put(E e) {
        E f = map.put(e, e);
        return f;
    }

    E get(E e) {
        return map.get(e);
    }

    public boolean contains(E o) {
        return map.containsKey(o);
    }

    E remove(E e) {
        return map.remove(e);
    }
}
