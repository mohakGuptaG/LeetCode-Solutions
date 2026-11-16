class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        reversefunc(s, i, j);
        return;
    }

    public static void reversefunc(char[] arr, int i, int j){
        if(i>=j){
            return;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reversefunc(arr, i+1, j-1);
    }
}