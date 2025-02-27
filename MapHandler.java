package algo.maphandler;

import java.util.*;

/**
 * Handles add and retrieve operations on Maps.
 */
public class MapHandler {

    /**
     * Creates a Map containing the provided entries. If there are multiple entries with the same key,
     * only the first occurrence is stored.
     *
     * @param entries entries with key and value
     * @return Map with the provided entries
     *
     * Tidskomplexitet: O(n log n) eftersom vi loopar igenom alla entries och sätter in dem i en TreeMap.
     */
    public Map<Integer, Integer> createMap(Entry[] entries) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Entry entry : entries) { // O(n)
            map.putIfAbsent(entry.key, entry.value); // O(log n) per insättning
        }
        return map;
    }

    /**
     * Retrieves a Map with the entries associated with the provided keys.
     *
     * @param map the map
     * @param keys keys for the entries we want to retrieve
     * @return Map containing the retrieved entries
     *
     * Tidskomplexitet: O(n log n) eftersom vi loopar igenom alla keys och hämtar dem från map.
     */
    public Map<Integer, Integer> retrieve(Map<Integer, Integer> map, int[] keys) {
        Map<Integer, Integer> result = new TreeMap<>();
        for (int key : keys) { // O(n)
            if (map.containsKey(key)) {
                result.put(key, map.get(key)); // O(log n) per insättning
            }
        }
        return result;
    }

    /**
     * Retrieves a Map containing the entries between the provided keys (including the from and to key).
     * Assumes input map is a TreeMap to maintain ordering.
     *
     * @param map the map
     * @param fromKey low endpoint of keys (inclusive)
     * @param toKey high endpoint of keys (inclusive)
     * @return Map containing the entries between the provided keys (including the from and to key)
     *
     * Tidskomplexitet: O(1) eftersom vi använder subMap-metoden på TreeMap.
     */
    public Map<Integer, Integer> retrieve(Map<Integer, Integer> map, int fromKey, int toKey) {
        if (!(map instanceof TreeMap)) {
            throw new IllegalArgumentException("Input map must be a TreeMap for range queries.");
        }
        return ((TreeMap<Integer, Integer>) map).subMap(fromKey, true, toKey, true); // O(1)
    }

    /**
     * Retrieves all keys from the map.
     * @param map the map
     * @return Collection with all keys
     *
     * Tidskomplexitet: O(1) eftersom vi använder keySet-metoden på Map.
     */
    public Collection<Integer> retrieveAllKeys(Map<Integer, Integer> map) {

        return map.keySet(); // O(1)
    }
    /**
     * Retrieves all values from the map.
     * @param map the map
     * @return Collection with all values
     *
     * Tidskomlexitet: O(1) eftersom vi använder values-metoden på Map.
     */
    public Collection<Integer> retrieveAllValues(Map<Integer, Integer> map) {
        return map.values(); // O(1)
    }
}
