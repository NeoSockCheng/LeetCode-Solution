package Problems.Q0199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

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

    // bfs
    // public List<Integer> rightSideView(TreeNode root) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     List<Integer> list = new ArrayList<>();

    //     if (root == null) {
    //         return list;
    //     }

    //     q.add(root);

    //     while (!q.isEmpty()) {
    //         int size = q.size();

    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = q.poll();
    //             if (i == size-1) {
    //                 list.add(node.val);
    //             }

    //             if (node.left != null) {
    //                 q.add(node.left);
    //             }
    //             if (node.right != null) {
    //                 q.add(node.right);
    //             }
    //         }
    //     }
    //     return list;

    // }

    
    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;

        if (level == res.size()) {
            res.add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);

    }
}

// question: look at the bst from right side, return a single list of what you can see (rightmost node)
// bfs: traverse thtrough each root, add to queue from left to right, then add the last one of each loop into list
// dfs: create a helper class which add root to the queue if level==q.size (means it is the first one get to the queue)
// each recursive loop, call for hte right side first