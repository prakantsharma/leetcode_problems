class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int index, List<String> path, List<String> ans) {

        // Found 4 parts
        if (path.size() == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        // Try segment lengths 1 to 3
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            int value = Integer.parseInt(part);

            if (value <= 255) {
                path.add(part);
                backtrack(s, index + len, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}