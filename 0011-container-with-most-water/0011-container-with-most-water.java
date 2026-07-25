class Solution {
    public int maxArea(int[] height) {
        int curr = 0;
        int max = 0;
        
        int i=0, j=height.length-1;

        while(i<j){
            if(height[i]<=height[j]){
                curr = height[i]*(j-i);
                max = Math.max(max, curr);
                i++;
            }
            else{
                curr = height[j]*(j-i);
                max = Math.max(max, curr);
                j--;
            }
        }
        return max;
    }
}