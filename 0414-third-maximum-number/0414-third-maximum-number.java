class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = max1;
        long max3 = max1;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i]<max1 && nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i]>max3 && nums[i]<max2){
                max3 = nums[i];
            }
        }

        if(max3==Long.MIN_VALUE){
            return (int)max1;
        }
        else{
            return (int)max3;
        }
    }
}