class pair {
    int first;
    int second;

    public pair(int first, int second) {
       this.first = first;
         this.second = second;
    }
}
class Solution {
    
   public void bfs(int row, int col, boolean vis[][], char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(row, col));
        vis[row][col] = true;
        while (!q.isEmpty()) {
            int i = q.peek().first;
            int j = q.peek().second;
            q.poll();
            for (int r = -1; r <= 0; r++) {
                int nrow = i + r;
                int ncol = j + r + 1;

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = true;
                    q.add(new pair(nrow, ncol));
                }

            }
            for (int r = 0; r <= 1; r++) {
                int nrow = i + r;
                int ncol = j + r - 1;
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = true;
                    q.add(new pair(nrow, ncol));
                }
            }

        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
}
