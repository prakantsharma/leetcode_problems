class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> trees = new ArrayList<>();

        // Empty tree
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int root = start; root <= end; root++) {

            List<TreeNode> leftTrees = build(start, root - 1);
            List<TreeNode> rightTrees = build(root + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;

                    trees.add(node);
                }
            }
        }

        return trees;
    }
}