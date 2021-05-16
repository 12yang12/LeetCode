package unionFind;

/**
 * 200. 岛屿数量
 */

public class LeetCode200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int water = 0;
        UnionFind unionFind = new UnionFind(grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    water++;
                } else {
                    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            unionFind.union(x * col + y, i * col + j);
                        }

                    }
                }
            }
        }
        return unionFind.getCount() - water;
    }

}
