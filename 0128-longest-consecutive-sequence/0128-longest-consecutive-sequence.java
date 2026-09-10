class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();

        if(nums.length==0){
            return 0;
        }

        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }

        int longest = 1;
        int last = Integer.MIN_VALUE;

        for(int x: st){
            if(!st.contains(x-1)){
                int count = 1;

                while(st.contains(x+1)){
                    count++;
                    x++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}