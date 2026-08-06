class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int n : nums){
            int csize=ans.size();
            for(int i=0;i<csize;i++){
            List<Integer> x=new ArrayList<>(ans.get(i));
            x.add(n);
            ans.add(x);
        }
        }
        
        return ans;
    }
}