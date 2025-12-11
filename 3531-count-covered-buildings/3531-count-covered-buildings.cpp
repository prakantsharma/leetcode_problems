class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& build) {
        
        int m = build.size();
        
        // Count buildings per row and per column
        unordered_map<int, int> rowCnt, colCnt;

        // Track min/max column for each row
        unordered_map<int, int> rowMin, rowMax;

        // Track min/max row for each column
        unordered_map<int, int> colMin, colMax;

        // First pass: gather all row/column statistics
        for (int i = 0; i < m; i++) 
        {
            int x = build[i][0];
            int y = build[i][1];

            // count buildings in this row/column
            rowCnt[x]++;
            colCnt[y]++;

            // update row min/max positions
            if (!rowMin.count(x)) 
            {
                rowMin[x] = y;
                rowMax[x] = y;
            } 
            else 
            {
                rowMin[x] = min(rowMin[x], y);
                rowMax[x] = max(rowMax[x], y);
            }

            // update column min/max positions
            if (!colMin.count(y)) 
            {
                colMin[y] = x;
                colMax[y] = x;
            } 
            else 
            {
                colMin[y] = min(colMin[y], x);
                colMax[y] = max(colMax[y], x);
            }
        }

        int ans = 0;

        // Second pass: check if each building is fully covered
        for (int i = 0; i < m; i++) 
        {
            int x = build[i][0];
            int y = build[i][1];

            // Must have at least 3 buildings in row & column
            if (rowCnt[x] < 3 || colCnt[y] < 3) continue;

            // Cannot be the leftmost or rightmost in its row
            if (y == rowMin[x] || y == rowMax[x]) continue;

            // Cannot be the topmost or bottommost in its column
            if (x == colMin[y] || x == colMax[y]) continue;

            // Building is covered from all four directions
            ans++;
        }

        return ans;
    }
};
