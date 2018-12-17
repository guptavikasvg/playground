import java.util.*;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

 * Created by root1 on 5/20/17.
 */
public class LeastFrequentlyUsedCache<K, V> {
    private static class ValueWithFrequency<V> {
        V value;
        int freq;

        public ValueWithFrequency(V value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    Map<K, ValueWithFrequency> map;
    int threshold;

    Set<K> leastFreqUsedKeys;
    int minFrequency;

    public LeastFrequentlyUsedCache(int threshold) {
        map = new HashMap(1 + (int)(threshold / 0.75));
        leastFreqUsedKeys = new HashSet<K>();
        this.threshold = threshold;
    }

    V get(K key) {
        ValueWithFrequency<V> vf = map.get(key);
        if (vf == null) {
            return null;
        }

        if (minFrequency == vf.freq) {
            // update minFrequency & leastFreqUsedKeys if needed
            int lfuSetSize = leastFreqUsedKeys.size();
            if (lfuSetSize > 1) {
                leastFreqUsedKeys.remove(key);
            } else {
                assert lfuSetSize == 1;
                minFrequency++;
            }
        }

        //increment frequency if present
        vf.freq++;

        return vf.value;
    }

    void put(K key, V value) {

        //
        // key exists. replace old value with new value
        //
        ValueWithFrequency valueWithFrequency = map.get(key);
        if (valueWithFrequency != null) {
            if (minFrequency > 1) {
                // update minFrequency and leastFreqUsedKeys
                leastFreqUsedKeys.clear();
                leastFreqUsedKeys.add(key);
                minFrequency = 1;
            }
            map.put(key, new ValueWithFrequency(value, 1));
            return;
        }

        //
        // key does not exist
        //
        if (map.size() < threshold) {
            //
            // no eviction needed
            //
            map.put(key, new ValueWithFrequency(value, 1));

            // update minFrequency and leastFreqUsedKeys
            if (minFrequency > 0) {
                leastFreqUsedKeys.clear();
            }
            minFrequency = 1;
            leastFreqUsedKeys.add(key);
        } else {
            //
            // eviction needed
            //

            //remove one of the LFU item
            if (minFrequency == 1) {
                leastFreqUsedKeys.remove(leastFreqUsedKeys.iterator().next());
            } else {
                assert minFrequency > 1;
                leastFreqUsedKeys.clear();
                minFrequency = 1;
            }
            leastFreqUsedKeys.add(key);

            map.put(key, new ValueWithFrequency(value, 1));
        }
    }
}
