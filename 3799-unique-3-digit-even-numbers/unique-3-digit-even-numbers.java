class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(digits[i]==0) continue;
            for(int j=0;j<n;j++){
                if(j==i) continue;
                for(int k=0;k<n;k++){
                    if(k==i || k==j) continue;
                    if(digits[k]%2!=0) continue;
                    int number=digits[i]*100 +digits[j]*10+digits[k];
                    if(!ans.contains(number)){
                        ans.add(number);
                    }
                }
            }
        }
        return ans.size();
    }
}