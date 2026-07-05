class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        
        long[][] dp = new long[n + 1][n + 1];
        long[][] cnt = new long[n + 1][n + 1];
        
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        
        for (long[] row : dp) Arrays.fill(row, -1);
        
        dp[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) continue;
                if (grid[i][j] == 'X') continue;
                
                long best = -1;
                long ways = 0;
                
                int[][] from = {{i + 1, j}, {i, j + 1}, {i + 1, j + 1}};
                
                for (int[] f : from) {
                    int fi = f[0], fj = f[1];
                    if (fi < n && fj < n && dp[fi][fj] >= 0) {
                        if (dp[fi][fj] > best) {
                            best = dp[fi][fj];
                            ways = cnt[fi][fj];
                        } else if (dp[fi][fj] == best) {
                            ways = (ways + cnt[fi][fj]) % MOD;
                        }
                    }
                }
                
                if (best >= 0) {
                    int val = (grid[i][j] == 'S' || grid[i][j] == 'E') ? 0 : (grid[i][j] - '0');
                    dp[i][j] = best + val;
                    cnt[i][j] = ways;
                }
            }
        }
        
        if (dp[0][0] < 0) return new int[]{0, 0};
        return new int[]{(int) dp[0][0], (int) cnt[0][0]};
    }
}