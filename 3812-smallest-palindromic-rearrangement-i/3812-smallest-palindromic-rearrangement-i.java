class Solution {
    public String smallestPalindrome(String s) {

        if(s.length()==1){
            return s;
        }
        
        char[] arr = new char[s.length()/2];
    
        for(int i=0; i<s.length()/2; i++){
           arr[i] = s.charAt(i);
        }

        Arrays.sort(arr);

        StringBuilder p = new StringBuilder(new String(arr));

        StringBuilder q = new StringBuilder(p).reverse();

        if(s.length()%2!=0){
            return p.append(s.charAt(s.length()/2)).append(q).toString();
        }
        else{
            return p.append(q).toString();
        }
    }
}