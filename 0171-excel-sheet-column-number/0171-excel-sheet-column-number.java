class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int sum = 0;

        for(int i=n-1; i>=0; i--){
            sum+= (columnTitle.charAt(i)-'A'+1)*Math.pow(26, (n-1)-i);
        }

        return sum;
    }
}