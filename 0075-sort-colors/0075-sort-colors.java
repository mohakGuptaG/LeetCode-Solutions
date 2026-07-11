class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        for(int i=n; i>1; i--){
            int last = i;

            for(int j=0; j<last-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        
    }
}