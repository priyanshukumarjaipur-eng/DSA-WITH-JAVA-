class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean seen[]=new boolean[256];
        int max=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            while(seen[c]){
                seen[s.charAt(l)]=false;
                l++;
            }
            seen[c]=true;
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}