class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int f = -1, c = -1;

        if(nums.length<=1){
            int[] ans = new int[2];
            if(nums.length==1 && nums[0]==target){
                ans[0] = 0;
                ans[1] = 0;
                return ans;
            }

            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
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

        int[] ans = new int[2];
        
        ans[0] = f;
        ans[1] = c;

        return ans;
    }
}