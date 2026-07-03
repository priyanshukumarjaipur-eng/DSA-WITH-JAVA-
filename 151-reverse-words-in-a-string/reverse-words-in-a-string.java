class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            int j = i;
            // Find the start of the word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Append the word
            sb.append(s.substring(j + 1, i + 1));
            sb.append(' ');

            i = j;
        }

        // Remove the trailing space
        return sb.toString().trim();
    }
}
