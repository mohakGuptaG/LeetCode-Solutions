class Solution {
    public int minimumPushes(String word) {
        int n = word.length()%8;
        int m = word.length()/8;
        int p = (m*(m+1))/2;
        return (8*p)+(n*(m+1));
    }
}