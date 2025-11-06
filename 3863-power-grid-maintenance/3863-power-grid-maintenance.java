class Solution {
    private int[] root;
    private List<Integer>[] paths;
    private int[] visited;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        root = new int[c + 1];
        paths = new ArrayList[c + 1];
        visited = new int[c + 1];
        Map<Integer, TreeSet<Integer>> root_map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= c; i++){
            root[i] = i;
            paths[i] = new ArrayList<>();
        }

        for(int[] x: connections){
            paths[x[0]].add(x[1]);
            paths[x[1]].add(x[0]);
        }

        for(int i = 1; i <= c; i++){
            if(visited[i] == 0){
                TreeSet<Integer> se = new TreeSet<>();
                dfs(i, i, se);
                root_map.put(i, se);
            }
        }

        for(int[] q: queries){
            int i = q[1];
            int root_i = root[i];

            if(q[0] == 2){
                root_map.get(root_i).remove(i);
            }
            else{
                if(root_map.get(root_i).contains(i)){
                    ans.add(i);
                }
                else{
                    if(root_map.get(root_i).size() == 0) ans.add(-1);
                    else ans.add(root_map.get(root_i).first());
                }
            }
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void dfs(int root_i, int i, TreeSet<Integer> se){
        visited[i] = 1;
        root[i] = root_i;
        se.add(i);

        for(int u: paths[i]){
            if(visited[u] == 0){
                dfs(root_i, u, se);
            }
        }
    }
}