class Solution {
    public int[][] mergeArrays(int[][] a, int[][] b)
     { 
        Map<Integer,Integer> map=new TreeMap<>();
        for(int[] a1:a ){
            map.put(a1[0],a1[1]);
        }
        for(int [] a2:b){
            if(map.containsKey(a2[0])){
                map.put(a2[0],map.get(a2[0])+a2[1]);
            }
            else{
                map.put(a2[0],a2[1]);
            }
        }
        int [][] ans=new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans[i][0]=entry.getKey();
            ans[i][1]=entry.getValue();
            i++;
        }
        return ans;

    }
}