package backtracking;

public class LC37 {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        // 遍历行
        for (int i = 0; i < board.length; i++) {
            // 遍历列
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                // (i, j) 这个位置放k是否合适
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        // 放置k
                        board[i][j] = k;
                        // 如果找到合适一组立刻返回
                        if (backtracking(board)) {
                            return true;
                        }
                        // 回溯，撤销k
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     **/
    private boolean isValid(int row, int col, char val, char[][] board) {
        // 判断行里是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // 判断列里是否重复i
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        // 判断9方格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

}
