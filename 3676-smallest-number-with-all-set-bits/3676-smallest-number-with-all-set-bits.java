class Solution {
    public int smallestNumber(int n) {
        int count=0;
        int w=1;
        while(w<= n)
        {
            w*=2;
            count++;
        }
        return (1<< count)-1;
        
    }
}