package hashTable;

import java.util.HashSet;
import java.util.Set;

public class LC202 {

    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (sumSet.contains(sum)) {
                return false;
            } else {
                sumSet.add(sum);
            }
            n = sum;
        }
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
