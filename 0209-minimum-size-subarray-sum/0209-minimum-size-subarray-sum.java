class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0; 
        int sum = 0;
        int min = nums.length+1;

        for(int j=0; j<nums.length; j++){
            sum+=nums[j];
            while(sum>=target){
                min = Math.min(min, j-i+1);
                sum = sum - nums[i];
                i++;
            }
        }
        if(min!=nums.length+1) return min;
        else return 0;
    }
}