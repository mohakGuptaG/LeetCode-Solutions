class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqA = new int[26];

        for(int i=0; i<s1.length(); i++){
            freqA[s1.charAt(i)-'a']++;
        }

        int left = 0;
        int right = s1.length()-1;

        while(right<s2.length()){
            int[] freqB = new int[26];
            for(int i=left; i<=right; i++){
                freqB[s2.charAt(i)-'a']++;
            }
            if(Arrays.equals(freqA, freqB)){
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}