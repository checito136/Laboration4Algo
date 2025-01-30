package algo.maphandler;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Invokes algorithm with small sized data structure to help you establish that
 * your algorithm implementation is correct.
 */
public class AlgoMap {
    /**
     * Program entry point.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        MapHandler mapHandler = new MapHandler();
        Map<Integer, Integer> map;
        int[] keys;
        Entry[] entries;

        /*
         *  Testing MapHandler.createMap(Entry[] entries)
         */

        entries = new Entry[100];
        for(int i = 0; i < entries.length; i ++) {
            entries[i] = new Entry(i, i);
        }
        Entry[] entriesWithExtra = new Entry[105];
        System.arraycopy(entries, 0, entriesWithExtra, 0, 100);
        entriesWithExtra[100] = new Entry(10, 11);
        entriesWithExtra[101] = new Entry(28, 0);
        entriesWithExtra[102] = new Entry(90, 100);
        entriesWithExtra[103] = new Entry(0, 10);
        entriesWithExtra[104] = new Entry(11, 22);

        map = mapHandler.createMap(entriesWithExtra);

        boolean correct = true;
        int i = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() != entries[i++].value) {
                correct = false;
            }
        }
        System.out.println("Creating map with " + entries.length + " entries (" + entries.length + "  unique). Correct: " + (correct && map.size() == entries.length));

        /*
         *  Testing TreeMapHandler.retrieve(TreeMap<Integer, Integer> tree, int[] keys)
         */

        entries = new Entry[100];
        for(i = 0; i < entries.length; i ++) {
            entries[i] = new Entry(i, i);
        }
        entries[15] = new Entry(10, 11);
        entries[36] = new Entry(28, 0);
        entries[99] = new Entry(90, 100);
        entries[69] = new Entry(0, 10);
        entries[53] = new Entry(11, 22);

        map = mapHandler.createMap(entries);

        keys = new int[] { 14, 16, 28 , 9, 10, 11, 3, 1, 55, 56, 57, 0, 90 };
        Map<Integer, Integer> retrieved = mapHandler.retrieve(map, keys);

        Arrays.sort(keys);

        correct = true;
        i = 0;
        for(Map.Entry<Integer, Integer> e : retrieved.entrySet()) {
            if(e.getValue() != keys[i++]) {
                correct = false;
            }
        }
        System.out.println("Retrieving " + keys.length + " elements from TreeMap. Correct: " + (!retrieved.isEmpty() && correct));

        /*
         *  Testing TreeMapHandler.retrieve(TreeMap<Integer, Integer> tree, int fromKey, int toKey)
         */
        entries = new Entry[100];
        for(i = 0; i < entries.length; i ++) {
            entries[i] = new Entry(i, i);
        }
        map = mapHandler.createMap(entries);
        retrieved.clear();
        retrieved = mapHandler.retrieve(map, 10, 30);

        correct = true;

        for(i = 10; i <= 30; i ++) {
            if(retrieved.get(i) != entries[i++].value) {
                correct = false;
            }
        }
        System.out.println("Retrieving tree with " + retrieved.size() + " entries. Correct: " + (correct && retrieved.size() == 21));

        /*
         * Testing TreeMapHandler.retrieveAllKeys(TreeMap<Integer, Integer> tree)
         */
        entries = new Entry[100];
        for(i = 0; i < entries.length; i ++) {
            entries[i] = new Entry(i, i * 2);
        }
        map = mapHandler.createMap(entries);

        Integer[] retrievedKeys = mapHandler.retrieveAllKeys(map).toArray(new Integer[100]);

        correct = true;

        for(i = 0; i < entries.length; i ++) {
            if(retrievedKeys[i] != entries[i++].key) {
                correct = false;
            }
        }
        System.out.println("Retrieving all keys. Correct: " + correct);

        /*
         * Testing TreeMapHandler.retrieveAllValues(TreeMap<Integer, Integer> tree)
         */

        entries = new Entry[100];
        for(i = 0; i < entries.length; i ++) {
            entries[i] = new Entry(i, i * 3);
        }
        map = mapHandler.createMap(entries);

        Integer[] retrievedValues  = mapHandler.retrieveAllValues(map).toArray(new Integer[100]);

        correct = true;

        for(i = 0; i < entries.length; i ++) {
            if(retrievedValues[i] != entries[i++].value) {
                correct = false;
            }
        }
        System.out.println("Retrieving all values. Correct: " + correct);
    }
}