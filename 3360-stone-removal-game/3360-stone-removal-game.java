class Solution {
    public boolean canAliceWin(int n) {
        boolean flag = false;
        int last = 10;

        while(last <= n){
           n = n - last;
           flag = !flag;
           last--;
        }

        return flag;
    }
}