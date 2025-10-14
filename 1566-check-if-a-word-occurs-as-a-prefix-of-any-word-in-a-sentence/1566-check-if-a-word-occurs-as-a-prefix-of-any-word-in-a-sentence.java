class Solution {
    public int isPrefixOfWord(String sentence, String searchword) {
        int searchwordlen=searchword.length();
        String [] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].length()<searchwordlen){
                continue;
            }
            else if(searchword.equals(words[i].substring(0,searchwordlen))){
                return i+1;
            }
        }
        return -1;
    }
}