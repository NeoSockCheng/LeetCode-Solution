package Problems.Q0572_Subtree_of_Another_Tree;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// public class Solution {

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         return helper(root, subRoot);
//     }
    
//     private boolean isSameTree(TreeNode a, TreeNode b) {
//         if (a == null && b == null) {
//             return true;
//         }

//         if (a != null && b != null && a.val == b.val) {
//             return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
//         }

//         return false;
//     }
    
//     private boolean helper(TreeNode root, TreeNode subRoot) {

//         if(root==null){
//             return false;
//         }
        
//         if (isSameTree(root, subRoot)) 
//             return true;
            

//         return helper(root.left, subRoot) || helper(root.right, subRoot);
//     }
// }
   

public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String a = serialize(root);
        String b = serialize(subRoot);
        return a.contains(b);
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "N";
        }
        return "(" + node.val + "," + serialize(node.left) + "," + serialize(node.right) + ")";
    }

}

// Question: check if a tree is a substree of another tree
// solution: 1: use the same tree function, check the root node, then check left || right
// Solution: 2: make it into string, and then see if a.contains(b)
    