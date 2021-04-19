package set;

import java.util.HashSet;

public class SetTest {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        // [1, 2, 3, 4]

        System.out.println(set);

        // search element
        boolean contains = set.contains(2);

        // delete element
        set.remove(2);
        // [1, 3, 4]

        int size = set.size();
        System.out.println(size);

    }
}
