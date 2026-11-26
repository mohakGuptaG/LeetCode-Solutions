class Solution {
    public boolean canAliceWin(int n) {
        boolean flag = false;
        int last = 10;

        if(n<10){
            return false;
        }

        while(last <= n){
           n = n - last;
           flag = !flag;
           last--;
        }

        return flag;
    }
}