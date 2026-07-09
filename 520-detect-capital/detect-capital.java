class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercase=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>=65 && word.charAt(i)<=90){
                uppercase++;
            }
        }
        if(uppercase==word.length() || uppercase==0 || (uppercase==1 && Character.isUpperCase(word.charAt(0)))){
            return true;
        }
        return false;
    }
}