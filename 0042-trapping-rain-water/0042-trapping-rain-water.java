class Solution {
    public int trap(int[] height) {
        Stack<Integer> maxPrefix = new Stack<>();
        Stack<Integer> maxSuffix = new Stack<>();

        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        maxPrefix.add(height[0]);

        for(int i=0; i<height.length; i++){
            if(height[i]>maxPrefix.peek()){
                maxPrefix.add(height[i]);
            }

            prefix[i] = maxPrefix.peek();
        }

        maxSuffix.add(height[height.length-1]);

        for(int i=height.length-1; i>=0; i--){
            if(height[i]>maxSuffix.peek()){
                maxSuffix.add(height[i]);
            }

            suffix[i] = maxSuffix.peek();
        }

        int[] min = new int[height.length];

        for(int i=0; i<height.length; i++){
            min[i] = Math.min(prefix[i], suffix[i]);
        }

        int water = 0;

        for(int i=0; i<height.length; i++){
            water += min[i] - height[i];
        }

        return water;
    } 
}