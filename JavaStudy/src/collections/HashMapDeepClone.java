package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by vgupta on 4/20/15.
 */
public class HashMapDeepClone<K,V> {

    public Map<K,V> cloneMap(Map<K,V> map) {
        Map<K,V> newMap = new HashMap<K, V>(map.size(), .75f);
        Set<Map.Entry<K,V>> set = map.entrySet();

        for (Map.Entry<K,V> entry : set) {
            K key = entry.getKey();
            V val = entry.getValue();

            if (key instanceof Cloneable && val instanceof Cloneable) {
                //TODO
            }


        }

        //TODO
        return null;
    }
}
