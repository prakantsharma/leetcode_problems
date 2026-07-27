import java.util.*;

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

       
        ArrayList<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            visited.add(false);
        }

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                dfs(i, adj, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     ArrayList<Boolean> visited) {

        visited.set(node, true);

        for (int neighbor : adj.get(node)) {
            if (!visited.get(neighbor)) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}