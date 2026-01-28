package y25.leetcode.week3;

import java.util.*;

public class P257 {

    public static void main(String[] args) {
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        search(answer, root, new ArrayList<>());
        return answer;
    }

    private void search(List<String> result, TreeNode current, List<TreeNode> path) {
        if (current.left == null && current.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode treeNode : path) {
                sb.append(treeNode.val)
                        .append("->");
            }
            sb.append(current.val);
            result.add(sb.toString());
            return;
        }

        if (path.contains(current)) {
            return;
        }

        path.add(current);
        if (current.left != null) {
            search(result, current.left, path);
        } else {
            search(result, current.right, path);
        }
        path.remove(current);

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
