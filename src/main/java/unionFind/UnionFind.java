package unionFind;

public class UnionFind {
    private int[] root;
    private int[] rank;
    private int count;

    public UnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        count = row * col;
        root = new int[count];
        rank = new int[count];
        for (int i = 0; i < count; i++) {
            root[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int index) {
        if (index == root[index]) {
            return root[index];
        } else {
            return root[index] = find(root[index]);
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }

}
