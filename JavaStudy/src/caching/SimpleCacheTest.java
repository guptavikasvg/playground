package caching;

import org.junit.Test;

import java.util.*;

import static caching.SimpleCacheFactory.getCache;

/**
 * Created by root1 on 5/5/17.
 */

interface Cache <K, V>{
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    void dumpCache();
}

/*
interface EvictionStrategy {
    boolean evictOne(Cache cache);
}*/

class SimpleCache<K,V> implements Cache<K,V> {
    private int size;
    private Map<K,V> map;
    //private EvictionStrategy evictionStrategy; //TODO initialize this.

    public SimpleCache(int size) {
        this.size = size;
        map = new HashMap<K, V>();
    }

    @Override
    public V put(K key, V value) {
        //check for nulls
        if (key == null) {
            return null;
        }

        //if update, let it through
        if (map.containsKey(key)) {
            return map.put(key, value);
        }

        //Now key does not exist
        //check capacity
        int cacheSize = map.size();
        if (cacheSize >= size) {
            // remove 1 element
            //evictionStrategy.evictOne(this);
            Set<Map.Entry<K, V>> entries = map.entrySet();
            ArrayList<Map.Entry<K, V>> entries1 = new ArrayList<>(entries);

            int i = new Random().nextInt(cacheSize);

            Map.Entry<K, V> kvEntry = entries1.get(i);
            map.remove(kvEntry.getKey());
        }

        //insert/update
        return map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public void dumpCache() {
        System.out.println("Map: " + map.toString());
    }
}

class SimpleCacheFactory {
    public static <K, V> Cache<K, V> getCache(int size) {
        return new SimpleCache<>(size);
    }
}


public class SimpleCacheTest {
    @Test
    public void test1() throws Exception {
        Cache<String, String> cache = SimpleCacheFactory.getCache(2);

        cache.remove("k1");
        cache.put("k1", "v1");
        cache.dumpCache();
        cache.put("k2", "v2");
        cache.dumpCache();
        cache.put("k3", "v3");
        cache.dumpCache();
    }
}