class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(nums[0], 0);
        for(int i=1; i<nums.length; i++){
            if(mp.containsKey(target-nums[i])){
                return new int[] {mp.get(target-nums[i]), i};
            }
            else{
                mp.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}