class Solution {
    public int minChanges(String s) {
        int i = 0;
        int j = 1;

        int change = 0;

        while(j<s.length()){
            int m = (int)(s.charAt(i));
            int n = (int)(s.charAt(j));

            if((m^n) != 0){
                change++;
            }

            i += 2;
            j += 2;
        }

        return change;
    }
}