class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 1000;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val){
                nums[i]=n;
                count++;
            }
        }
        Arrays.sort(nums);
        return (nums.length)-count;
    }
}