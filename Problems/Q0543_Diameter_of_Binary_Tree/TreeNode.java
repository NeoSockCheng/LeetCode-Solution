package Problems.Q0543_Diameter_of_Binary_Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return diameter;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        int currentDiameter = leftDepth + rightDepth;

        diameter = Math.max(currentDiameter, diameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// QUestion: find the longest line in a binary tree
// Solution: dfs, get the max depth of left and right side
// current diameter of a node is the sum of left and right