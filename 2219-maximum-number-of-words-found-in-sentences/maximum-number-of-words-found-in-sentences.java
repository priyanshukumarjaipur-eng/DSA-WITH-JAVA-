class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for(String s:sentences){
            int word=1;
            for(char s1: s.toCharArray()){
                if(s1==' '){
                    word++;
                }
            }
            max=Math.max(max,word);
        }
        return max;
    }
}