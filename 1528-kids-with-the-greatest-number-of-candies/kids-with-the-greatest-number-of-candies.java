class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> l=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies<max){
                l.add(false);
            }
            else{
                l.add(true);
            }
        }
        return l;
        }
}