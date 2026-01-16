class Solution {
    public int findNumbers(int[] a) {
        
        int n=a.length;
        int count=0;
        for(int e:a){
            if(Integer.toString(e).length()%2==0){
                count++;
            }
        }
        return count;
        
    }
}