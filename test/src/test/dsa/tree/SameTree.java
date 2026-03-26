package test.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {
    private static TreeNode generateTree1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(11);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }
    private static TreeNode generateTree2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(11);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    // Recursive version (dfs)
    public static boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }
        if(tree1 == null || tree2 == null) {
            return false;
        }
        if(tree1.val != tree2.val) {
            return false;
        }
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }
    // Iterative version (dfs)
    public static boolean isSameTreeIterative(TreeNode tree1, TreeNode tree2) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{tree1, tree2});
        while(!stack.isEmpty()) {
            TreeNode[] pair = stack.pop();
            TreeNode p = pair[0], q = pair[1];

            if(p==null && q==null) {
                continue;
            }
            if(p == null || q == null || p.val != q.val) {
                return false;
            }
            stack.push(new TreeNode[]{p.left, q.left});
            stack.push(new TreeNode[]{p.right, q.right});
        }

        return true;
    }

    // BFS version
    public static boolean isSameTreeQueue(TreeNode tree1, TreeNode tree2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree1);
        queue.offer(tree2);

        while(!queue.isEmpty()) {
            TreeNode p = queue.poll(), q = queue.poll();
            if(p == null && q ==  null) {
                continue;
            }
            if(p == null || q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree1 = generateTree1();
        TreeNode tree2 = generateTree2();

        System.out.println(isSameTreeQueue(tree1, tree2)); // true
    }
}
