package cachemapinpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The CacheMapInpl class provides methods for
 * Cache with automatic expiration of entries
 * @version 1.01 17.03.2017
 * @author Yury Kovalchuk
 */
public class CacheMapInpl<KeyType, ValueType> implements CacheMap<KeyType, ValueType> 
{

	private Map<KeyType, ValueContainer<ValueType>> cache;
	private long timeToLive;
	
	public CacheMapInpl() 
	{
		// initialization cache as HashMap structure 
        cache = new HashMap<KeyType, ValueContainer<ValueType>>();
        
        // default time keep entries in the cache
        timeToLive = 1000;
    }
	
	// class container of values : value and timeSet
	private class ValueContainer<ValueType> 
	{

		private ValueType value;
		private Long timeSet;

	    	public ValueContainer(ValueType value, Long timeSet) 
	    	{
	    		this.value = value;
	    		this.timeSet = timeSet;
	    	}

	        public Long getTimeSet() 
	        {
	            return timeSet;
	        }

	        public ValueType getValue() 
	        {
	            return value;
	        }
	        
	    	@Override
	    	public boolean equals(Object obj) 
	    	{
	            return value.equals(obj);
	        }

	        @Override
	        public int hashCode() 
	        {
	            return value.hashCode();
	        }
	}
	   
	/**
	 * Sets how long new entries are kept in the cache. Until this method is called,
	 * some kind of default value should apply.
	 * @param timeToLive time keep entries in the cache
	 */
	public void setTimeToLive(long timeToLive)
	{
		this.timeToLive=timeToLive;
	}

	/**
	 * Get how long new entries are kept in the cache
	 * @return time keep entries in the cache
	 */
	public long getTimeToLive()
	{
		return timeToLive;
	}

    /**
     * Caches the given value under the given key.
     *
     * If there already is an item under the given key, it will be replaced by the new value. <p>
     *
     * @param key may not be null
     * @param value item may be null, in which case the cache entry will be removed (if it existed).
     * @return the previous value, or null if none
     */
    public ValueType put(KeyType key, ValueType value)
    {
    	// clear all expired entries
    	clearExpired();
    	// get from cache previous value by key
    	ValueType previousValue = (cache.get((KeyType) key) != null ) ? cache.get((KeyType) key).getValue() : null;
    	
    	// add or replace cache entry 
    	Object returnValue = cache.put(key, new ValueContainer<ValueType>(value, Clock.getTime())) ;
    	
    	// return the previous value, or null if none
    	return (returnValue != null) ? previousValue : null;
    }

    /**
     * Clears all expired entries.
     * This is called automatically in conjuction with most operations,
     * but for memory optimization reasons you may call this explicitely at any time.
	 */
    public void clearExpired()
    {
    	// list of expired entries for remove 
    	List<KeyType> entriesRemove = new ArrayList<>();
 
    	// get list of expired entries
        for (Entry<KeyType, ValueContainer<ValueType>> cacheEntry : cache.entrySet()) 
        {
        	Long timeSet = cacheEntry.getValue().getTimeSet();

        	if (Clock.getTime()- timeSet > timeToLive) 
        	{
        		entriesRemove.add((KeyType) cacheEntry.getKey());
        	}
        }
        
        // Remove expired entries from cache
        for (KeyType key : entriesRemove) {
        	cache.remove((KeyType) key);
        }
    }

    /**
     * Removes all entries.
     */
    public void clear()
    {
    	cache.clear();
    }

    /**
     * Checks if the given key is included in this cache map.
     * @param key key of entry in the cache
     * @return true if the given key included in cache else return false
     */
    public boolean containsKey(Object key)
    {
      	// clear all expired entries
    	clearExpired();
    	
      	//  return false if the given value not included in cache
    	return cache.containsKey((KeyType) key);
    }

    /**
     * Checks if the given value is included in this cache map.
     * @param value value of entry in the cache
     * @return true if the given value included in cache else return false
    */
    public boolean containsValue(Object value)
    {
      	// clear all expired entries
    	clearExpired();

      	//  return true if the given value is included in cache
        for (Entry<KeyType, ValueContainer<ValueType>> cacheEntry : cache.entrySet()) {
            if (cacheEntry.getValue().equals(value))
              	//  return true if the given value included in cache
            	return true;
        }
        
      	//  return false if the given value not included in cache
        return false;
    }

    /**
     * Returns the value for the given key. Null if there is no value,
     * or if it has expired.
     * @param key key of entry in the cache
     * @return value for the given key, or null if none
     */
    public ValueType get(Object key)
    {
      	// clear all expired entries
    	clearExpired();
    	
    	// get from cache value for the given key
     	ValueType returnValue = (cache.get((KeyType) key) != null ) ? cache.get((KeyType) key).getValue() : null;

    	// return value for the given key, or null if none
    	return (returnValue != null) ? returnValue : null;    	
    }

    /**
     * True if this cache is empty.
     */
    public boolean isEmpty()
    {
      	// clear all expired entries
    	clearExpired();
    	
      	// return true if cache is empty else return false 	
    	return cache.isEmpty();
    }

    /**
     * Removes the given key.
     * @param key key of entry in the cache
     * @return the previous value, if there was any
     */
    public ValueType remove(Object key)
    {
      	// clear all expired entries
    	clearExpired();
    	
    	// get from cache previous value by key
    	ValueType previousValue = (cache.get((KeyType) key) != null ) ? cache.get((KeyType) key).getValue() : null;
    	
    	// return the previous value, or null if none
    	return (cache.remove((Integer) key) != null) ? previousValue : null;
    }

    /**
     * How many entries this cache map contains.
     * @return count entries of cache
     */
    public int size()
    {
    	// clear all expired entries
    	clearExpired();
    	
    	// return count entries of cache
    	return cache.size();
    }
    
}




