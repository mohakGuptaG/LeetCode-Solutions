class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int secMax = 0;

        int p = n;
        int q = n;

        while(n>0){
            int m = n%10;
            max = Math.max(max, m);
            n = Math.floorDiv(n, 10);
        }
        int count=0;
        while(q>0){
            int c = q%10;
            if(c==max){
                count++;
            }
            q = Math.floorDiv(q, 10);
        }

        if(count>=2){
            return max*max;
        }

        while(p>0){
            int o = p%10;
            if(o<max){
                secMax = Math.max(secMax, o);
            }
            p = Math.floorDiv(p,10);
        }
        return max*secMax;
    }
}