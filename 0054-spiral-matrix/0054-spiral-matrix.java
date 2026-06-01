class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int stRow = 0;
        int endRow = n - 1;
        int stCol = 0;
        int endCol = m - 1;

        while (stRow <= endRow && stCol <= endCol) {

            // Top boundary
            for (int j = stCol; j <= endCol; j++) {
                ans.add(matrix[stRow][j]);
            }

            // Right boundary
            for (int i = stRow + 1; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }

            // Bottom boundary
            if (stRow < endRow) {
                for (int j = endCol - 1; j >= stCol; j--) {
                    ans.add(matrix[endRow][j]);
                }
            }

            // Left boundary
            if (stCol < endCol) {
                for (int i = endRow - 1; i > stRow; i--) {
                    ans.add(matrix[i][stCol]);
                }
            }

            stRow++;
            endRow--;
            stCol++;
            endCol--;
        }

        return ans;
    }
}