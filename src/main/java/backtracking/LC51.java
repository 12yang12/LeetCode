package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backtracking(n, 0, chessboard);

        return result;
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        if (n == row) {
            result.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        // 这是一个剪枝
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] chars : chessboard) {
            list.add(new String(chars));
        }

        return list;
    }
}
