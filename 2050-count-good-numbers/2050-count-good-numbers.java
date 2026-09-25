class Solution {
    public static final int mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = n/2 + n%2;
        long odd = n/2;

        long evenways = power(5, even);
        long oddways = power(4, odd);

        long total = (evenways * oddways) % mod;

        return (int) total;
    }

    public static long power(long x, long n){

        if(n == 0){
            return 1;
        }

        if(n%2 == 0){
            return power((x*x) % mod, (n/2));
        }

        return (x * power(x, (n-1))) % mod;
    }
}