class Solution {
   public void getSubsets(
            int[] nums,
            List<Integer> ans,
            int index,
            List<List<Integer>> allSubsets) {

        // Base case
        if (index == nums.length) {
            allSubsets.add(new ArrayList<>(ans)); // COPY
            return;
        }

        // Include
        ans.add(nums[index]);
        getSubsets(nums, ans, index + 1, allSubsets);

        // Backtrack
        ans.remove(ans.size() - 1);

     getSubsets( nums, ans,index+1, allSubsets);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int index=0;
        getSubsets(nums,ans,index,allSubsets);
        return allSubsets;
        
    }
}