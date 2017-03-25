

//1ms solution, bottom up idea came from discussion
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return subDepth(root) != -1;
        
    }
    public int subDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = subDepth(root.left);
        int right = subDepth(root.right);
        if (left == - 1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
