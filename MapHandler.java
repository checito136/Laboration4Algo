package algo.maphandler;

import java.util.Collection;
import java.util.Map;

/**
 * Handles add and retrieve operations on TreeMaps.
 */
public class MapHandler {
    /**
     * Creates a Map containing the provides entries. If there are more than one entry with the same key,
     * the first entry value is added. Following entries with identical keys will not replace the previously added value.
     *
     * @param entries entries with key and value
     * @return Map with the provided entries
     */
    public Map<Integer, Integer> createMap(Entry[] entries) {

        //TODO: Add implementation
        return null;
    }
    /**
     * Retrieves a Map with the entries associated with the provided keys.
     *
     * @param map the map
     * @param keys keys for the entries we want to retrieve
     * @return Map containing the retrieved entries
     */
    public Map<Integer, Integer> retrieve(Map<Integer, Integer> map, int[] keys) {

        //TODO: Add implementation
        return null;
    }
    /**
     * Retrieves a Map containing the entries between the provided keys (including the from and to key).
     * @param map the map
     * @param fromKey low endpoint of keys (inclusive)
     * @param toKey high endpoint of keys (inclusive)
     * @return Map containing the entries between the provided keys (including the from and to key)
     */
    public Map<Integer, Integer> retrieve(Map<Integer, Integer> map, int fromKey, int toKey) {

        //TODO: Add implementation
        return null;
    }
    /**
     * Retrieves all keys from the map.
     * @param map the map
     * @return Collection with all keys
     */
    public Collection<Integer> retrieveAllKeys(Map<Integer, Integer> map) {

        //TODO: Add implementation
        return null;
    }
    /**
     * Retrieves all values from the tree.
     * @param map the map
     * @return Collection with all values
     */
    public Collection<Integer> retrieveAllValues(Map<Integer, Integer> map) {

        //TODO: Add implementation
        return null;
    }
}