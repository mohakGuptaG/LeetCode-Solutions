class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int f = -1, c = -1;
        
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==target){
                f = mid;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int center = (start+end)/2;

            if(nums[center]==target){
                c = center;
                start = center + 1;
            }
            else if(nums[center]>target){
                end = center - 1;
            }
            else{
                start = center+1;
            }
        }
        return new int[]{f,c};
    }
}