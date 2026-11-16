class Solution {
    public int numOfSubarrays(int[] arr) {
        long preSum = 0;

        int m = 1_000_000_007;

        long count = 0;

        int even = 1;
        int odd = 0;

        for(int i=0; i<arr.length; i++){
            preSum += arr[i];

            if(preSum % 2 == 0){
                even++;

                count += (long) odd;
            }
            else{
                odd++;
                count += (long)even;
            }

        } 

        return (int) (count % m) ;
    }
}