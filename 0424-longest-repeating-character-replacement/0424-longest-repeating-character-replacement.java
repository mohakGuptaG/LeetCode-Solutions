class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int right = 0;
        int ans = 1;
        int currMax = 0;
        char currChar = s.charAt(0);

        while(right<s.length()){
            freq[s.charAt(right)-'A']++;
            if(freq[s.charAt(right)-'A']>currMax){
                currMax = Math.max(currMax, freq[s.charAt(right)-'A']);
                currChar = s.charAt(right);
            }

            int replace = (right-left+1) - currMax;

            if(replace <= k){
                ans = Math.max(ans, right-left+1);
            }

            else{
                freq[s.charAt(left)-'A']--;
                left++;
            }

            right++;
        }
        return ans;
    }
}