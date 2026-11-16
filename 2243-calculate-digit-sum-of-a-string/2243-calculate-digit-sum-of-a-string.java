class Solution {
    public String digitSum(String s, int k) {
        String t = round(s, k);

        return t;
    }

    public static String round(String s, int k){

        while(s.length() > k){  

        int sum = 0;
        StringBuilder res = new StringBuilder();
        int count = 0;
            

                for(int i=0; i<s.length(); i++){
                    int digit = Integer.valueOf(s.charAt(i) - '0');

                    sum += digit;
                    count++;

                        if(count == k){
                            count = 0;
                            res = res.append(String.valueOf(sum));
                            sum = 0;
                        }
                }

            
            if(s.length() % k != 0){
                res = res.append(String.valueOf(sum));
            }

            s = res.toString();

            res.setLength(0);
        }

        return s;
    }
} 