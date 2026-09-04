class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--){
            int pos = nums2[i];

            while(!st.isEmpty() && st.peek()<=pos){
                st.pop();
            }

            if(st.isEmpty()){
                mp.put(pos, -1);
            }
            else{
                mp.put(pos, st.peek());
            }

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for(int i=0; i<ans.length; i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}