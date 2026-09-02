class Solution {
    public boolean validPalindrome(String s) {
        int left = 0 , right = s.length()-1;

        int count = 0;

        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return check(s, left+1, right) || check(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean check(String g , int l , int r){
        while(l<r){
            if(g.charAt(l)!=g.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}