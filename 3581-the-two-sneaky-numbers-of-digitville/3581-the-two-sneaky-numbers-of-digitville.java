class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] ans=new int[2];
        int [] count=new int[nums.length];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            if(count[nums[i]]==2){
                ans[idx]=nums[i];
                idx++;
            }
            if(idx==2){
                break;
            }

        }
        return ans;
    }
}