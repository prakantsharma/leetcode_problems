class Solution {
    public int minSubArrayLen(int key, int[] arr) 
    { 
    int n=arr.length;
    int currSum=0;
    int low=0;
    int high=0;
    int minLenwindow=Integer.MAX_VALUE;
    for( high=0;high<n;high++){
        currSum+=arr[high];
        while(currSum>=key){
            int currentWindow=high-low+1;
            minLenwindow=Math.min(minLenwindow,currentWindow);
            currSum=currSum-arr[low];
            low++;
            
        }

    }
    return minLenwindow==Integer.MAX_VALUE?0:minLenwindow;

        
    }
}