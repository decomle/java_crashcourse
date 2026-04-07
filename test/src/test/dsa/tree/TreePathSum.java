package test.dsa.tree;

import java.util.*;

public class TreePathSum {
    private static TreeNode generateTestTree() {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, null, new TreeNode(1));
        return root;
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false;
        record NodeSum(TreeNode node, int sum){};

        Queue<NodeSum> queue = new LinkedList<>();
        queue.offer(new NodeSum(root, root.val));
        while(!queue.isEmpty()) {
            NodeSum nodeSum = queue.poll();
            TreeNode node = nodeSum.node;
            if(node.left == null && node.right==null) {
                if(nodeSum.sum == target ) {
                    return true;
                }
            }

            if(node.left != null) queue.offer(new NodeSum(node.left, nodeSum.sum + node.left.val));
            if(node.right != null) queue.offer(new NodeSum(node.right, nodeSum.sum + node.right.val));
        }
        return false;
    }

    public boolean hasPathSumOptimal(TreeNode root, int targetSum) {
        if(root==null) return false;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, lastVisited = null;

        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                sum += cur.val;
                cur = cur.left;
            }
            TreeNode peek = stack.peek();
            if(peek.right != null && lastVisited != peek.right) {
                cur = peek.right;
            } else {
                if (peek.left == null && peek.right == null) {
                    if (sum == targetSum) return true;
                }
                lastVisited = stack.pop();
                sum -= lastVisited.val;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPathSum(generateTestTree(), 22)); // True: 5 + 4 + 11 + 2
    }

}
