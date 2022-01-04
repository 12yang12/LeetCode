package greedy;

public class LC134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                // 起始位置更新为i+1  curSum从0开始
                start = i + 1;
                curSum = 0;
            }
        }

        return (totalSum < 0) ? -1 : start;
    }

}
