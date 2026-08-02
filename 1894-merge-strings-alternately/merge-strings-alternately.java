class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        StringBuilder s=new StringBuilder();
        int i=0;
        while(i<n && i<m){
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
            i++;
        }
        while(i<n){
            s.append(word1.charAt(i));
            i++;
        }
        while(i<m){
            s.append(word2.charAt(i));
            i++;
        }
        return s.toString();
    }
}