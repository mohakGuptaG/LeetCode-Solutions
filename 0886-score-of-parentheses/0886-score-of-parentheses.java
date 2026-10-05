class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(0);
            } else {
                int val = stack.pop();
              
                int scoreToAdd = Math.max(2 * val, 1);
                stack.push(stack.pop() + scoreToAdd);
            }
        }

        return stack.peek();
    }
}