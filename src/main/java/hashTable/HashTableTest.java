package hashTable;

import java.util.HashMap;

public class HashTableTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        // Time Complexity: O(1)
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // update element
        // Time Complexity: O(1)
        map.put(1, "D");

        // remove element
        // Time Complexity: O(1)
        map.remove(1);

        // get value
        // Time Complexity: O(1)
        String value = map.get(3);

        // check value
        // Time Complexity: O(1)
        boolean isContainsKey = map.containsKey(1);

        int size = map.size();
        boolean empty = map.isEmpty();
    }
}
