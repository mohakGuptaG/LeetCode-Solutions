class Solution {
    public void sortColors(int[] nums) {
        int min = 0;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            min = i;

            for(int j=i+1; j<n; j++){
                if(nums[j]<nums[min]){
                    int temp = nums[j];
                    nums[j] = nums[min];
                    nums[min] = temp;
                }
            }
        }
    }
}