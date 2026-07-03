class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int idx=0;
        while(i<n){
             int count=0;
            int j=i;
            while(j<n && chars[j]==chars[i]){
                count++;
                j++;
            }
            chars[idx++]=chars[i];
            if(count>1){
                String cntStr = String.valueOf(count);
                for (char c : cntStr.toCharArray()) {
                    chars[idx++] = c;
                }
            }
            i=j;
        }
        return idx;
    }
}