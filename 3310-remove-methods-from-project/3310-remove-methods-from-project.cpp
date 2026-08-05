class Solution {
public:
    void dfs(int u, vector<vector<int>>& graph, vector<bool>& suspicious) {
        suspicious[u] = true;
        for (int v : graph[u]) {
            if (!suspicious[v]) {
                dfs(v, graph, suspicious);
            }
        }
    }

    vector<int> remainingMethods(int n, int k, vector<vector<int>>& invocations) {
        vector<vector<int>> graph(n);

        for (auto &e : invocations) {
            graph[e[0]].push_back(e[1]);
        }

        vector<bool> suspicious(n, false);
        dfs(k, graph, suspicious);

        // If any non-suspicious method invokes a suspicious one,
        // we cannot remove the suspicious group.
        for (auto &e : invocations) {
            int u = e[0], v = e[1];
            if (!suspicious[u] && suspicious[v]) {
                vector<int> ans;
                for (int i = 0; i < n; i++)
                    ans.push_back(i);
                return ans;
            }
        }

        vector<int> ans;
        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.push_back(i);
        }

        return ans;
    }
};