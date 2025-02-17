package Problems.Q0226_Invert_Binary_Tree;


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
 
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         reverseChild(root);
//         return root;
//     }

//     public void reverseChild(TreeNode root) {
//         if (root == null)
//             return null;
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//          reverseChild(root.left);
//         reverseChild(root.right);
//     }

// } 

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// question: inverse the binary tree (left-right)
// solution: traverse through each node, and switch left and right node
