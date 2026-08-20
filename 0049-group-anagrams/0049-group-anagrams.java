class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> ans = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] ch = new char[strs[i].length()];
            ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if(!ans.containsKey(s)){
                ans.put(s, new ArrayList<>());
            }

            ans.get(s).add(strs[i]);
        }
        return new ArrayList<>(ans.values());
    }
}