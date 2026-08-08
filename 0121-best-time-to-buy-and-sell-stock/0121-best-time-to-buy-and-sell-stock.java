class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int max = 0;

        int[] my = new int[prices.length-1];

        for(int i=0; i<my.length; i++){
            my[i] = prices[i+1] - prices[i];
        }

        int sum = 0;

        for(int i=0; i<my.length; i++){
            sum += my[i];
            max = Math.max(max, sum);
            if(sum<0){
                sum = 0;
            }
        }

        return max;
    }
}