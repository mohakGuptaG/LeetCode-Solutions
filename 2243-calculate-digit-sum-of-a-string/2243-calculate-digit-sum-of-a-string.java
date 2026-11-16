class Solution {
    public String digitSum(String s, int k) {
        String t = round(s, k);

        return t;
    }

    public static String round(String s, int k){
        int sum = 0;
        String res = "";
        int count = 0;

        while(s.length() > k){
                for(int i=0; i<s.length(); i++){
                    int digit = Integer.valueOf(s.charAt(i) - '0');

                    sum += digit;
                    count++;

                        if(count == k){
                            count = 0;
                            res += String.valueOf(sum);
                            sum = 0;
                        }
                }

            
            if(s.length() % k != 0){
                res += String.valueOf(sum);
            }

            s = res;

            res = "";

            count = 0;

            sum = 0;
        }

        return s;
    }
} 