class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=0;

        int[] ans = new int[2];

        while(i<numbers.length-1){
            j=i+1;
            while(j<numbers.length){
                if(numbers[i]+numbers[j]==target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }  
                j++; 
            }
            i++;           
        }
        return ans;
    }
}