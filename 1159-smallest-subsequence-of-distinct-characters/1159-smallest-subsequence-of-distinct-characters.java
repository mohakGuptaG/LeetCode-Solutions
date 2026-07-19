class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            count[idx]--;
            
            if (visited[idx]) {
                continue;
            }
            
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                char removedChar = sb.charAt(sb.length() - 1);
                visited[removedChar - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            sb.append(c);
            visited[idx] = true;
        }
        
        return sb.toString();
    }
}