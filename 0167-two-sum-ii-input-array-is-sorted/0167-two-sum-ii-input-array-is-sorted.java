class Solution {
    public int[] twoSum(int[] a, int target) {
        int n=a.length;
        int left=0;
        int right=n-1;
        while(left<right)
        {
            int sum=a[left]+a[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}