class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum=Integer.MIN_VALUE;
        int curr_sum=0;
        for(int el:nums){
            curr_sum+=el;
            if(curr_sum>max_sum){
                max_sum=curr_sum;
            }
            if(curr_sum<0){
                curr_sum=0;
            }
        }
        return max_sum;
        
    }
}