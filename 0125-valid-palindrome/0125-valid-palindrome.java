class Solution {
    public boolean isPalindrome(String s) {
      s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int lf=0;
        int rt=s.length()-1;
        while(lf<rt){
            if(s.charAt(lf)!=s.charAt(rt)){
                return false;

            }
            lf++;
            rt--;
        }
        return true;
        
    }
}