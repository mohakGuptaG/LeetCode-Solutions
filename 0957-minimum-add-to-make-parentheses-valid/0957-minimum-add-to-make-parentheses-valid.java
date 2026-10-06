class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
                count++;
            }
            else if(s.charAt(i)==')' && !st.isEmpty()){
                st.pop();
                count--;
            }
            else{
                count++;
            }
        }

        return count;
    }
}