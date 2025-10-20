/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    Set <Integer> seen;

    public FindElements(TreeNode root) {
        seen=new HashSet<>();
        bfs(root);
        
        
    }
    
    public boolean find(int target) {
        return seen.contains(target);

        
    }
    private void bfs(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        root.val=0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.remove();
            seen.add(curr.val);
            if(curr.left!=null){
                curr.left.val=2*curr.val+1;
                queue.add(curr.left);
            }if(curr.right!=null){
                curr.right.val=2*curr.val+2;
                queue.add(curr.right);
            }
        }

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */