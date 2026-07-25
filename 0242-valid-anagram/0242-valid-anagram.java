class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)+1);
            }
            else{
                mp.put(c,1);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(!mp.containsKey(t.charAt(i))){
                return false;
            }
            else{
                if(mp.get(t.charAt(i))==0){
                    return false;
                }
                else{
                    mp.put(t.charAt(i), mp.get(t.charAt(i))-1);
                }
            }
        }

        return true;
    }
}