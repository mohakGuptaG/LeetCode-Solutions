class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int high = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            high = Math.max(high, piles[i]);
        }

        int ans = Integer.MAX_VALUE;
        int low = 1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int res = mid;
            long total = 0;

            for(int j=0; j<n; j++){
                int p = piles[j];
                
                total+=(p+res-1)/res;
            }

            if(total<=h){
                ans = Math.min(ans, res);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}