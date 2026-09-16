import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        if (k == 0) return num;

        Stack<Character> s = new Stack<>();
        s.push(num.charAt(0));

        for (int i = 1; i < num.length(); ++i) {
            while (k > 0 && !s.isEmpty() && num.charAt(i) < s.peek()) {
                --k;
                s.pop();
            }
            s.push(num.charAt(i));

            if (s.size() == 1 && num.charAt(i) == '0') s.pop();
        }

        while (k > 0 && !s.isEmpty()) {
            --k;
            s.pop();
        }

        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        res.reverse();

        if (res.length() == 0) return "0";
        return res.toString();
    }
}
