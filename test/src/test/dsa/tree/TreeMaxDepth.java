package test.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMaxDepth {
    private static TreeNode generateTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static int maxDepthDfsRecursive(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthDfsRecursive(tree.left), maxDepthDfsRecursive(tree.right));
    }

    // BFS is built for this
    public static int maxDepth(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        int dept = 0;
        while(!queue.isEmpty()) {
            dept++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return dept;
    }

    public static void main(String[] args) {
        TreeNode tree = generateTree();

        System.out.println(maxDepth(tree));
    }
}
