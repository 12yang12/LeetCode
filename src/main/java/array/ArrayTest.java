package array;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayTest {

    public static void main(String[] args) {
        // 创建数组 方式1
        int[] array1 = {1, 2, 3};

        // 创建数组 方式2
        int[] array2 = new int[] {1, 2, 3};

        // 创建数组 方式3
        int[] array3 = new int[3];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i + 1;
        }

        // 以上述创建方式，打印数组
         System.out.println(Arrays.toString(array3));

        // 创建数组 方式4
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arrayList.add(i + 1);
        }
        // [1, 2, 3]

        // Add element,
        // Time Complexity: O(1)
        // 在数组尾部添加元素
        arrayList.add(4);
        // [1, 2, 3, 4]

        // Insert element
        // Time Complexity: O(N)
        // 在指定位置添加元素
        arrayList.add(0,6);
        // [6, 1, 2, 3, 4]

        // Access element
        // Time Complexity: O(1)
        int a = array1[1];
        int b = arrayList.get(1);

        // Update Element
        // Time Complexity: O(1)
        array1[1] = 10;
        arrayList.set(1, 10);

        // Remove Element
        // Time Complexity: O(N)
        arrayList.remove(0);

        // Iterate an array
        // Solution 1
        for (int i = 0; i < array1.length; i++) {
            int currentElement = array1[i];
            System.out.print(currentElement +" ");
        }
        // Solution 2
        for(int currentElement: array1) {
            System.out.print(currentElement +" ");
        }

        // Solution 1
        for (int i = 0; i < arrayList.size(); i++) {
            int currentElement = arrayList.get(i);
            System.out.print(currentElement +" ");
        }
        // Solution 2
        for (int currentElement : arrayList) {
            System.out.print(currentElement +" ");
        }
        System.out.println();
        // Find an element
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 8) {
                System.out.println("We found 1 in array1!");
            }
        }

        boolean isFind = arrayList.contains(1);

        // The length of an array
        // Time Complexity: O(1)
        int arraySize = array1.length;
        int arrayListSize = arrayList.size();

        // Sort an array by built-in lib
        array1 = new  int[] {5, 1, 0, 4};
        arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(4);
        // [5, 1, 0, 4]

        // from small to big
        // Time Complexity: O( N*log(N) )
        Arrays.sort(array1);
        Collections.sort(arrayList);
        // [0, 1, 4, 5]

        // from big to small
        // Time Complexity: O( N*log(N) )
        Collections.sort(arrayList, Collections.reverseOrder());
        // [5, 4, 1, 0]
        // for array1, you can read an array in reverse
        System.out.println(Arrays.toString(array1));
        System.out.println(arrayList);
    }

}
