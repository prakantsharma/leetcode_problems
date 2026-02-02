class Solution {
    public void getSubsets(
        int [] a,int i,List<Integer> ans,List<List<Integer>> allSubsets
    )
    {
        if(i==a.length){
            allSubsets.add(new ArrayList<>(ans));
            return ;
        }
        ans.add(a[i]);
        getSubsets(
         a,i+1, ans, allSubsets
    );
    ans.remove(ans.size()-1);
    int idx=i+1;
    while(idx<a.length && a[idx-1]==a[idx]){
        idx++;
    }
     getSubsets(
         a,idx, ans, allSubsets
    );



        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allSubsets=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int idx=0;
        getSubsets(nums,idx,ans,allSubsets);
        return allSubsets;
        
    }
}