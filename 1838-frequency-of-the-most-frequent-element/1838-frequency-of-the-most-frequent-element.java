class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int[] preSum = new int[nums.length];

        preSum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        int max = 1;

        for(int i=nums.length-1; i>0; i--){
            int freq = bsearch(preSum, nums, i, k);
            max = Math.max(max, freq);
        }

        return max;
    }

    public static int bsearch(int[] preSum, int[] nums, int t, int k){
        int l = 0;
        int r = t;

        int result = 1;

        while(l<=r){
            int mid = l + (r-l)/2;

            int count = nums[t] * (t - mid + 1);

            int pos = preSum[t] - preSum[mid] + nums[mid];

            if(k < count - pos){
                l = mid + 1;
            }
            else{
                result = mid;
                r = mid - 1;
            }
        }

        return t - result + 1;
    }
}