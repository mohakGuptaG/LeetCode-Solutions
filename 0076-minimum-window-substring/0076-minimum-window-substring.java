class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()<t.length()){
            return new String("");
        }

        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
        }

        int left = 0;
        int right = 0;

        int l=-1;
        int r=-1;
        int min = Integer.MAX_VALUE;
        int count = 0;

        while(right<s.length()){
            mp.put(s.charAt(right), mp.getOrDefault(s.charAt(right),0)-1);

            if(mp.get(s.charAt(right))>=0){
                count++;
            }

            while(count==t.length()){
                
                if(right-left+1<min){
                        min = right-left+1;
                        l = left;
                        r = right;
                }

                mp.put(s.charAt(left), mp.get(s.charAt(left))+1);

                if(mp.get(s.charAt(left))>0){
                    count--;
                }

                left++;
            }
                
            right++;
        }

       return min == Integer.MAX_VALUE ? new String("") : s.substring(l,r+1);
    }
}