class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> st = new HashSet<>();
       
        for(int i=0; i<s.length(); i++){
            if(!mp.containsKey(s.charAt(i))){
                if(!st.contains(t.charAt(i))){
                    mp.put(s.charAt(i), t.charAt(i));
                    st.add(t.charAt(i));
                }
                else{
                    return false;
                }
                
            }
            else{
                if(mp.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}