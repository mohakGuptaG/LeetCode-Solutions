class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=n/2; i>=1; i--){
            if(n%i==0){
                int t = n/i;
                String sub = s.substring(0,i);
                StringBuilder sb = new StringBuilder();

                while(t-->0){
                    sb.append(sub);
                }

                if(s.equals(sb.toString())){
                    return true;
                }
            }
        }

        return false;
    }
}