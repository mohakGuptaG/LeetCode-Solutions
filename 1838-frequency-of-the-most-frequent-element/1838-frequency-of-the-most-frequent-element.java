class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        long currSum = 0;
        int max = 1;
        int l = 0;
        long winSum = 0;

        for(int r=0; r<nums.length; r++){
            currSum +=(long )nums[r];

            winSum = (long)(r-l+1) * nums[r];

            if(winSum - currSum > k){
                while(winSum - currSum > k){
                    currSum -= (long)nums[l];
                    l++;
                    winSum = (long) nums[r] * (r-l+1);
                }
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}