class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0') return 0;

        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]

        for (int i = 2; i <= s.size(); i++) {
            int cur = 0;

            if (s[i - 1] != '0')
                cur += prev1;

            if (s.substr(i - 2, 2) >= "10" && s.substr(i - 2, 2) <= "26")
                cur += prev2;

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
};