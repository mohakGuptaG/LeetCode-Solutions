class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(0,0,"",n,res);

        return res;
    }

    public static void backtrack(int open, int close, String curr, int total, List<String> ans){
        if(curr.length()==2*total){
            ans.add(curr);
            return;
        }

        if(open < total){
            backtrack(open+1, close, curr+"(", total, ans);
        }

        if(close < open){
            backtrack(open, close+1, curr+")", total, ans);
        }
    }
}