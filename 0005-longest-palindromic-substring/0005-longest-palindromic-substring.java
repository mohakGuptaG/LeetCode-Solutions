class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;

        for(int k=0; k<s.length(); k++){
            int oddLen = getLength(k,k,s);
            int evenLen = getLength(k, k+1, s);

            if(oddLen > evenLen){
                if(oddLen > maxLength){
                    maxLength = oddLen;
                    start = k - oddLen/2;
                }
            }
            else{
                if(evenLen>maxLength){
                    maxLength = evenLen;
                    start = k - evenLen/2 + 1;
                }
            }
        }

        return s.substring(start, start+maxLength);
    }

    public int getLength(int left, int right, String s){
        while(left>=0 && right<s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }

            left--;
            right++;
        }

        return right-left-1;
    }
}