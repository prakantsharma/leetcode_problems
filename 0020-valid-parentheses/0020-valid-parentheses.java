class Solution {
    public boolean isValid(String str) {
        int n=str.length();
        Stack<Character> s=new Stack<>();
        for(int i=0;i<n;i++)
        {
            char curr=str.charAt(i);
            if(curr=='(' || curr=='{' || curr=='['){
                s.push(curr);
            }else{
                if(s.isEmpty()) return false;
                if(
                    (s.peek()=='(' && curr==')')||
                    (s.peek()=='[' && curr==']')||
                    (s.peek()=='{' && curr=='}')
                )
                {
                    s.pop();
                }else{
                    return false;

                }
            }
        }
        return s.isEmpty();
        
    }
}