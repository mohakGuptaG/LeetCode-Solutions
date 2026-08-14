class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        String s = columnTitle.toLowerCase();
        int sum = 0;

        for(int i=n-1; i>=0; i--){
            sum+= (s.charAt(i)-'a'+1)*Math.pow(26, (n-1)-i);
        }

        return sum;
    }
}