class Solution {
    public int minChanges(String s) {

        int change = 0;

        for(int i=0, j=1; j<s.length(); i+=2, j+=2){

            if(s.charAt(i)!=s.charAt(j)){
                change++;
            }
        }

        return change;
    }
}