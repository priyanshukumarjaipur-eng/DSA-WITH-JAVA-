class Solution {
    public int maximumCount(int[] arr) {
        int n=arr.length;
        int neg=0,pos=0;
        for(int ele : arr){
            if(ele<0) neg++;
            else if(ele>0) pos++;
        }
        return Math.max(neg,pos);
    }
}