class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        String ref = "aeiou";
        int res = 0;
        for(int i=left; i<=right; i++){
            if(ref.indexOf(words[i].charAt(0))!=-1 && ref.indexOf(words[i].charAt(words[i].length()-1))!=-1){
                res++;
            }
        }
        return res;
    }
}