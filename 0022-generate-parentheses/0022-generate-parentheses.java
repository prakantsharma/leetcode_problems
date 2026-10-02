class Solution {
    public static void sol(int n,int ob,int cb,String ans,ArrayList<String>li){
        if(cb>ob){
            return;
        }
        if(ob>n/2){
            return;
        }
        if(ob+cb==n){
            li.add(ans);
            return;
        }
        
        sol(n,ob+1,cb,ans+"(",li);
        sol(n,ob,cb+1,ans+")",li);

    }
    public List<String> generateParenthesis(int n) {
       ArrayList<String>li=new ArrayList();
       sol(2*n,0,0,"",li);
       return li;

    }
}