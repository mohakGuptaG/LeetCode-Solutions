class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        int p = 1;

        while (n > 0) {
            int d = n % 10;

            if (d != 0) {
                x += d * p;
                sum += d;
                p *= 10;
            }

            n /= 10;
        }

        return 1L * x * sum;
    }
}