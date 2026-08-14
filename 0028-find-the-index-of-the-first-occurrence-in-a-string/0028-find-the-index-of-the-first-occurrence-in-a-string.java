class Solution {
    public int strStr(String haystack, String needle) {
        int j = needle.length();
        int i = 0;
        boolean flag = false;

        while(j<=haystack.length()){
            if(haystack.substring(i,j).equals(needle)){
                flag = true;
                break;
            }
            i++;
            j++;
        }

        if(flag){
            return i;
        }
        else{
            return -1;
        }

    }
}