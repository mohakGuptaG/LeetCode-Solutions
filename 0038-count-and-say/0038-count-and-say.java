class Solution {
    public String countAndSay(int n) {
        String p = "1";

        if(n==1){
            return new String("1");
        }

        while(n-1>0){
            StringBuilder q = new StringBuilder();
            char a = p.charAt(0);
            int count = 1;
            for(int i=1; i<p.length(); i++){
                if(p.charAt(i)==a){
                    count++;
                }
                else{
                    q.append(count);
                    q.append(a);
                    count = 1;
                    a = p.charAt(i);
                }
            }
                q.append(count);
                q.append(a);
            p = q.toString();
            n--;
        }
        return p;
    }
}