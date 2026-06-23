class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }

        // Length = 2 initialization
        for (int i = 0; i < m; i++) {
            up[i] = m - 1 - i; // next element greater
            down[i] = i;       // next element smaller
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            // Suffix sums for down -> up transition
            long suffix = 0;
            for (int i = m - 1; i >= 0; i--) {
                suffix = (suffix + down[i]) % MOD;
                newUp[i] = (suffix - down[i] + MOD) % MOD;
            }

            // Prefix sums for up -> down transition
            long prefix = 0;
            for (int i = 0; i < m; i++) {
                newDown[i] = prefix;
                prefix = (prefix + up[i]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}