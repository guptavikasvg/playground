public abstract class ServerCache {

    private ServerCache _impl;

    public static ServerCache getInstance() {
        if (_impl != null) {
            return _impl;
        }

        synchronized(ServerCache.getClass()) {
            if ( _impl == null) {
                _impl = new ServerCacheImpl();
            }            
        }
        return _impl;
    }    

    public Object get(Object key);
    public Object put(Object key, Object value);
}

/**
 * eviction policy: 
 *
 */
class ServerCacheImpl extends ServerCache{
    
    HashMap map;

    private ServerCacheImpl() {
        map = new HashMap(capacity); 
    }

    public Object get(Object key) {
        return map.get(key);
    }
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }
    public Object remove(Object key, Object value) {
        return map.put(key, value);
    }
}




