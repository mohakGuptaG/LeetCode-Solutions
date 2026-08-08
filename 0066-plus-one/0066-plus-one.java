class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> arr = new ArrayList<>();
        digits[digits.length-1]+=1;
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]>9){
                arr.add(digits[i] - 10);
                if(i-1<0){
                    arr.add(1);
                }
                
                if(i-1>=0) digits[i-1] = digits[i-1] + 1;
            }
            else{
                arr.add(digits[i]);
            }
        }
        
        Collections.reverse(arr);

        int [] my = new int[arr.size()];

        for(int i=0; i<my.length; i++){
            my[i] = arr.get(i);
        }

        return my;
    }
}