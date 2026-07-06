import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending end if start is same
            }
            return a[0] - b[0]; // Ascending start
        });

        int count = 0;
        int end = 0;

        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;
                end = interval[1];
            }
        }

        return count;
    }
}