class Solution {
public:
    vector<int> parent, sz;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (sz[a] < sz[b]) swap(a, b);
        parent[b] = a;
        sz[a] += sz[b];
    }

    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int n = grid.size();

        vector<vector<int>> dist(n, vector<int>(n, -1));
        queue<pair<int,int>> q;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    dist[i][j] = 0;
                    q.push({i,j});
                }
            }
        }

        int dx[4] = {1,-1,0,0};
        int dy[4] = {0,0,1,-1};

        while (!q.empty()) {
            auto [x,y] = q.front();
            q.pop();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.push({nx,ny});
            }
        }

        vector<tuple<int,int,int>> cells;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells.push_back({dist[i][j], i, j});

        sort(cells.rbegin(), cells.rend());

        parent.resize(n * n);
        sz.assign(n * n, 1);

        for (int i = 0; i < n * n; i++)
            parent[i] = i;

        vector<vector<bool>> active(n, vector<bool>(n, false));

        for (auto &[d,x,y] : cells) {
            active[x][y] = true;

            int id = x * n + y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if (!active[nx][ny]) continue;

                unite(id, nx * n + ny);
            }

            if (active[0][0] && active[n-1][n-1] &&
                find(0) == find(n * n - 1))
                return d;
        }

        return 0;
    }
};