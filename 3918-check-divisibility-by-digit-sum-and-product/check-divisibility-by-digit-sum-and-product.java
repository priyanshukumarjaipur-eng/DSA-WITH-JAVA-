class Solution {
    public boolean checkDivisibility(int n) {
        int pr=1;
        int sum=0;
        int originalN=n;
        while(n!=0){
            int r=n%10;
            sum+=r;
            pr*=r;
            n=n/10;
        }
        int ans=sum+pr;
        if(originalN%ans==0){
            return true;
        }
        return false;
    }
}