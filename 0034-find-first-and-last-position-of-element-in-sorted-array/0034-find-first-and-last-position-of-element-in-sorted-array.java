class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;

        while(left <= right){
            int mid = left + (right - left) / 2 ;

            if(nums[mid] == target){
                start = mid;
                end = mid;

                while(nums[mid + 1] == target){
                    end = mid + 1;
                    mid++;
                }

                break;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }

            else{
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2 ;

            if(nums[mid] == target){
                start = mid;
                end = mid;

                while(nums[mid - 1] == target){
                    start = mid - 1;
                    mid--;
                }

                break;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }

            else{
                right = mid - 1;
            }
        }

        return new int[]{start, end};
    }
}