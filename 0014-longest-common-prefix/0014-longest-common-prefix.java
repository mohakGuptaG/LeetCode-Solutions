class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder match = new StringBuilder();

        for(int i=0; i<strs[0].length(); i++){
            match.append(strs[0].charAt(i));
        }

        for(int i=1; i<strs.length; i++){
            int j=0;
            while(j<strs[i].length() && j<match.length()){
                if(strs[i].charAt(j)!=match.charAt(j)){
                    break;
                }
                j++;
            }

            match.setLength(j);

            if(match.isEmpty()){
                return "";
            }
           
        }
        return match.toString();
    }
}