class Solution {
    static final int MOD = 1_000_000_007;

    int[] nums;
    int n;

    Integer[][][] memo;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        n = nums.length;

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        memo = new Integer[n][max + 1][max + 1];

        return dfs(0, 0, 0);
    }

    int dfs(int i, int g1, int g2) {

        if (i == n)
            return (g1 == g2 && g1 != 0) ? 1 : 0;

        if (memo[i][g1][g2] != null)
            return memo[i][g1][g2];

        long ans = dfs(i + 1, g1, g2);

        ans += dfs(i + 1,
                g1 == 0 ? nums[i] : gcd(g1, nums[i]),
                g2);

        ans += dfs(i + 1,
                g1,
                g2 == 0 ? nums[i] : gcd(g2, nums[i]));

        memo[i][g1][g2] = (int) (ans % MOD);
        return memo[i][g1][g2];
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}