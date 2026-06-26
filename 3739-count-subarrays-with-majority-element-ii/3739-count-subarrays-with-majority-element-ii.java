class Solution {

    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        BIT bit = new BIT(2 * n + 5);

        int pref = n + 2; // shifted prefix sum
        bit.update(pref, 1);

        long ans = 0;

        for (int x : nums) {
            if (x == target)
                pref++;
            else
                pref--;

            ans += bit.query(pref - 1);
            bit.update(pref, 1);
        }

        return ans;
    }
}