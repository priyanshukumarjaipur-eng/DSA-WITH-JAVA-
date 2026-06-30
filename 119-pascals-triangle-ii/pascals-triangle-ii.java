class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=rowIndex+1;
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) ans.get(i).add(j,1);
                else{
                    int val=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    ans.get(i).add(j,val);
                }
            }
        }
        return ans.get(rowIndex);
    }
}