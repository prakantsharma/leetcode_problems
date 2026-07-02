class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0][0] = grid.get(0).get(0);
        pq.offer(new int[]{dist[0][0], 0, 0});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (cost > dist[x][y])
                continue;

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                int newCost = cost + grid.get(nx).get(ny);

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new int[]{newCost, nx, ny});
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}