class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = 1_000_000_007L;
        int n = s.length();
        
        long[] prefixSum = new long[n + 1];
        long[] prefixVal = new long[n + 1];
        int[] nonZeroCount = new int[n + 1];
        long[] powersOf10 = new long[n + 1];

        powersOf10[0] = 1;
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            powersOf10[i + 1] = (powersOf10[i] * 10) % MOD;
            
            if (digit != 0) {
                prefixSum[i + 1] = prefixSum[i] + digit;
                prefixVal[i + 1] = (prefixVal[i] * 10 + digit) % MOD;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
                prefixVal[i + 1] = prefixVal[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            long currentSum = (prefixSum[R + 1] - prefixSum[L]);
            int count = nonZeroCount[R + 1] - nonZeroCount[L];
            long currentX = (prefixVal[R + 1] - (prefixVal[L] * powersOf10[count]) % MOD + MOD) % MOD;

            ans[i] = (int) ((currentX * (currentSum % MOD)) % MOD);
        }

        return ans;
    }
}