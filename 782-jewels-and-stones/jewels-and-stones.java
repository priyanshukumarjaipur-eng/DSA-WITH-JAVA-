class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean exist[]=new boolean[126];
        for(char c:jewels.toCharArray()){
            exist[c]=true;
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            char ch=stones.charAt(i);
            if(exist[ch]){
                count++;
            }
        }
        return count;
    }
}