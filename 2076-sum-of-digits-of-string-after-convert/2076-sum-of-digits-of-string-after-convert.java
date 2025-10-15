class Solution {
    public int getLucky(String s, int k) {
        String ans="";
        for(char ch:s.toCharArray()){
            ans+=Integer.toString(ch-'a'+1);
        }
        while(k-->0){
            int sum=0;
            for(char digit:ans.toCharArray()){
                sum+=digit-'0';
            }
            ans=Integer.toString(sum);

        

        
        }
        return Integer.parseInt(ans);

    }
}