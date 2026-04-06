class Solution {
    public int findKthPositive(int[] a, int k) {
        int n=a.length;
        for(int i=0;i<n;i++){
            int missing=a[i]-(i+1);
            if(missing>= k){
                return i+k;
            }
        }
        int totalMissing=a[n-1]-n;
        int remaining=k-totalMissing;
        return a[n-1]+remaining;
        
    }
}