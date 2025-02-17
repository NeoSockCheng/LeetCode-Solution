package Problems.Q0104_Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
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

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//     }
// }

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int width = queue.size();

            for (int i = 0; i < width; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return depth;
    }
}

// Question: getting the depth of a binary tree
// Approach: BFS
// use a queue, start from storing the root with depth 0
// then for each poll, poll all of the nodes and add children node in the queue
// and plus 1, until queue is empty
// Approach: DFS
// simpler, just return 1+ math.max  (method(left), method(right))

