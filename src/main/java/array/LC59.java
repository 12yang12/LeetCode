package array;

public class LC59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 定义每循环一个圈的起始位置
        int startX = 0;
        int startY = 0;
        // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int loop = n / 2;
        // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int mid = n / 2;
        // 用来给矩阵中每一个空格赋值
        int count = 1;
        // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int offset = 1;
        int i, j;

        while (loop-- > 0) {
            i = startX;
            j = startY;

            // 填充上行从左到右(左闭右开)
            for (; j < n - offset; j++) {
                res[startX][j] = count++;
            }

            // 填充填充右列从上到下(左闭右开)
            for (; i < n - offset; i++) {
                res[i][j] = count++;
            }

            // 填充下行从右到左(左闭右开)
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 填充左列从下到上(左闭右开)
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            // 第二圈开始的时候，起始位置要各自加1
            startX++;
            startY++;

            // offset 控制每一圈里每一条边遍历的长度
            offset += 1;
        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
