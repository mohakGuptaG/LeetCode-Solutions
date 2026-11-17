class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)]++;
        }

        int index = 0;

        StringBuilder sb = new StringBuilder();

        while(index < s.length()){
            int maxChar = 0;
            int maxFreq = 0;

            for(int i=0; i<freq.length; i++){
                if(freq[i] > maxFreq){
                    maxFreq = freq[i];
                    maxChar = i;
                }
            }

            for(int j=0; j<maxFreq; j++){
                char ch = (char) maxChar;
                sb.append(ch);
                index++;
            }

            freq[maxChar] = 0;
        }

        return sb.toString();
    }
}