class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }

        if(s.length()==0){
            return 0;
        }

        Set<Character> uni = new  HashSet<>();
        int max = 1;
        int left = 0, right = 0;

        while(right<s.length()){
            if(!uni.contains(s.charAt(right))){
                uni.add(s.charAt(right));
                max = Math.max(max, right-left+1);
            }
            else{
                while(uni.contains(s.charAt(right))){
                    uni.remove(s.charAt(left));
                    left++;
                }
                uni.add(s.charAt(right));
            }
            right++;
        }
        return max;
    }
}