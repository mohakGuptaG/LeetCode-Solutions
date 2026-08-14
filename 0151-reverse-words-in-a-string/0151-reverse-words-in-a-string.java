class Solution {
    public String reverseWords(String s) {
        
        boolean flag = false;

        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        int k = 0, j = s.length()-1;

        while(k<s.length()){
            if(s.charAt(k)!=' ') break;
            k++;
        }

        while(j>=0){
            if(s.charAt(j)!=' '){
                break;
            }
            j--;
        }

        for(int i=j; i>=k; i--){

            if(s.charAt(i)==' ' && flag){
                continue;
            }

            else if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                flag = false;
            }

            else{
                ans.append(sb.reverse());
                ans.append(" ");
                sb.setLength(0);
                flag = true;
            }
        }

        ans.append(sb.reverse());

        return ans.toString();
    }
}