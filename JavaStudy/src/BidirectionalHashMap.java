import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Assumes nulls are not inserted in the map
public abstract class  BidirectionalHashMap<K,V> implements Map<K,V> {

    Map<K,V> k2v = new HashMap<K,V>();
    Map<V,K> v2k = new HashMap<V,K>();


    public V put(K key, V value) {
        //removes existing key, values

        V V1 = k2v.get(key);

        if (V1 != null) {
            k2v.remove(key);

            K K2 = v2k.remove(V1);
            assert k2v.get(K2) == null; //K2 should already be removed.
        }

        K K1 = v2k.get(value);
        if (K1 != null) {
            v2k.remove(value);

            V V2 = k2v.remove(K1);
            assert k2v.get(V2) == null; //V2 should already be removed.
        }

        //insert in both
        assert k2v.put(key, value) == null;
        assert v2k.put(value, key) == null;

        return V1;
    }

    @Override
    public int size() {
        assert k2v.size() == v2k.size();
        return k2v.size();
    }

    @Override
    public boolean isEmpty() {
        assert k2v.isEmpty() == v2k.isEmpty();
        return k2v.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    public V remove(Object key) {
        V value = get(key);
        k2v.remove(key);
        if (value != null) {
            v2k.remove(value);
        }

        return value;
    }


    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return k2v.entrySet();
    }
}

/*

bidirectional hashmap

K -> V
V -> K

Have 2 hash maps

class BiMap implements Map {

    V getValueForKey(K) {
        return k2v.get(K);
    }

    K getKeyForValue(V) {
        return v2k(V);
    }

    //TODO implement iterator

    Iterator getIterator() {
        return new Iterator();
    }

    class Iterator {
        Iterator() {

        }

        hasNext() {

        }

        next();



    }
}

K , V
10, 20

--
k2v          v2k
---          ---
K , V1      V1, K2
10, 30      30, 10
step1       step2

K1, V2      V, K1
5, 20       20, 5
step4       step3



 */
