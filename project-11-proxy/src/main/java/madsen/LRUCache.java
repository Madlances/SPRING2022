package madsen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is to make sure the cache db keeps a most-recently-used list of up to SIZE elements (use 5). 
 */

public class LRUCache<Key,Value> extends LinkedHashMap<Key,Value> {
    private Integer size;

    public LRUCache(Integer size) {
        super(size);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Key, Value> oldest) {
        return size() > size;
    }
}
