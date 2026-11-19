class Solution {
    public int minimizeSum(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int score = Integer.MAX_VALUE;

            return Math.min(score, Math.min(nums[n-2] - nums[1], Math.min(nums[n-1] - nums[2], nums[n-1-2] - nums[0])));
    }
}