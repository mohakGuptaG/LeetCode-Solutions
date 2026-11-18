class Solution {
    public int minChanges(String s) {

        int change = 0;

        for(int i=0, j=1; j<s.length(); i+=2, j+=2){
            int m = (int)(s.charAt(i));
            int n = (int)(s.charAt(j));

            if((m^n) != 0){
                change++;
            }
        }

        return change;
    }
}