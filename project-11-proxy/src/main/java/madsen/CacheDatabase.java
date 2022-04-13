package madsen;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class will keep a most-recently-used list of up to SIZE elements (use 5). 
 * When users call get( ) or exists() on such a database, retrieve from the cache if it’s previously been 
 * fetched and is still in the cache. Otherwise retrieve it from the file and add it to the cache. Don’t let the cache exceed SIZE entries
 */

public class CacheDatabase implements Database{
    private final Integer maxCacheSize = 5;
    private LRUCache<String, String> cache = new LRUCache<>(this.maxCacheSize); // this is the most recently used list

    private Database db;
    public CacheDatabase(Database db) {
        this.db = db;
    }
    
    /**
     * this function returns the data bases id
     */
    @Override
    public String getId() {
        return this.db.getId();
    }

    /**
     * This function returns the data from the cache if it has been fetch and still in the cache
     * Otherwise retrieve it from the file and add it to the cache.
     */
    @Override
    public boolean exists(String key) {
        if (cache.containsKey(key)) {
            System.out.println("Found key " + key + " in cache");
            return true;
        } else {
            return this.db.exists(key);
        }
    }

    /**
     * This function returns the data from the cache if it has been fetch and still in the cache
     * Otherwise retrieve it from the file and add it to the cache.
     */
    @Override
    public String get(String key) {
        if (cache.containsKey(key)) {
            System.out.println("Found key " + key + " in cache");
            return cache.get(key);
        } else {
            String value = this.db.get(key);
            cache.put(key, value);
            return value;
        }
    }

    /**
     * This function will return the keys in the cache in order, so we can see what is in the cache at any time. 
     * @return
     */
    public ArrayList<String> inspect() {
        ArrayList<String> keys = new ArrayList<>(this.cache.keySet());
        Collections.reverse(keys);
        return keys;
    }
}
