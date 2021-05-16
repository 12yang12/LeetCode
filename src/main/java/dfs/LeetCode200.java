package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        // DFS
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                }
                dfs(grid, i, j, row, col);
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i, j - 1, row, col);
        dfs(grid, i, j + 1, row, col);
    }


    public int numIslands2(char[][] grid) {
        // BFS
        if (grid == null || grid.length == 0) {
            return 0;

        }
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new int[]{x + 1, y});
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new int[]{x - 1, y});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new int[]{x, y - 1});
                        }
                        if (y + 1 < col && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                }
            }
        }

        return result;
    }
}
