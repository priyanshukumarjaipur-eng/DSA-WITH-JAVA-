class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.indexOf(")") != -1) {
            int close = sb.indexOf(")");
            int open = sb.lastIndexOf("(", close);
            String inside = sb.substring(open + 1, close);
            String reversed = new StringBuilder(inside).reverse().toString();
            sb.replace(open, close + 1, reversed);
        }

        return sb.toString();
    }
}
