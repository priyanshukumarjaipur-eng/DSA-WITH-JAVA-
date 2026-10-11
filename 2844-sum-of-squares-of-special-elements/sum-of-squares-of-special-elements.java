class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(n%(i+1)==0){
                int special=nums[i];
                sum+=Math.pow(special,2);
            }
        }
        return sum;
    }
}