class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backtrack(0,0,sb,n,res);

        return res;
    }

    public static void backtrack(int open, int close, StringBuilder sb,int total, List<String> ans){
        if(sb.length()==2*total){
            ans.add(sb.toString());
            return;
        }

        if(open < total){
            sb.append('(');
            backtrack(open+1, close, sb, total, ans);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(')');
            backtrack(open, close+1,sb, total, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}