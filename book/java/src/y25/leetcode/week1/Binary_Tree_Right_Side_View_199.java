package y25.leetcode.week1;

import java.util.*;

public class Binary_Tree_Right_Side_View_199 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        Queue<TreeNodeWithDepth> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithDepth(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeWithDepth node = queue.poll();

            if (node.treeNode == null) {
                continue;
            }

            if (answer.size() <= node.depth) {
                answer.add(node.treeNode.val);
            } else {
                answer.set(node.depth, node.treeNode.val);
            }

            if (node.treeNode.left != null) {
                queue.offer(new TreeNodeWithDepth(node.treeNode.left, node.depth + 1));
            }
            if (node.treeNode.right != null) {
                queue.offer(new TreeNodeWithDepth(node.treeNode.right, node.depth + 1));
            }
        }
        return answer;
    }

    private static class TreeNodeWithDepth {
        TreeNode treeNode;
        int depth;

        TreeNodeWithDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public static class TreeNode {
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
}
