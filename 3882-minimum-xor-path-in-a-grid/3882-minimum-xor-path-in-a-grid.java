public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int maxVal = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxVal = Math.max(maxVal, val);
            }
        }
        
        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }
        limit = Math.max(limit, 1024);

        boolean[][][] dp = new boolean[m][n][limit];

        int startVal = grid[0][0];
        dp[0][0][startVal] = true;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int cellVal = grid[r][c];

                for (int v = 0; v < limit; v++) {
                    if (r > 0 && dp[r - 1][c][v]) {
                        dp[r][c][v ^ cellVal] = true;
                    }
                    if (c > 0 && dp[r][c - 1][v]) {
                        dp[r][c][v ^ cellVal] = true;
                    }
                }
            }
        }

        for (int v = 0; v < limit; v++) {
            if (dp[m - 1][n - 1][v]) {
                return v;
            }
        }

        return -1;
    }
}