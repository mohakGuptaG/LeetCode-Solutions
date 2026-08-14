class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<>();

        if(s.length()==0){
            return true;
        }

        for(int i=s.length()-1; i>=0; i--){
            st.add(s.charAt(i));
        }

        for(int i=0; i<t.length(); i++){

            if(!st.isEmpty()){
                if(t.charAt(i)==st.peek()){
                    st.pop();
                }
            }
        }

        if(st.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}