class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> myList = new ArrayList<>();

        int l = String.valueOf(low).length();
        int h = String.valueOf(high).length();

        String m = "123456789";

        for(int i=l; i<=h; i++){
            int left = 0;
            int right = i;
            while(right<=m.length()){
                String s = m.substring(left, right);
                int n = Integer.valueOf(s);
                if(n<=high && n>=low){
                    myList.add(n);
                }
                left++;
                right++;
            }
        }
        return myList;
    }
}