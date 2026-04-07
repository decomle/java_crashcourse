package test.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// One type of DFS (Depth-First Search): With ROOT -> LEFT -> RIGHT
public class PreorderTraversal {
    private static TreeNode generateTestTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        root.right.right = new TreeNode(8, new TreeNode(9), null);
        return root;
    }

    public static List<Integer> preOrderTransverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, lastVisited = null;
        while(cur != null || !stack.isEmpty()) {
            while(cur!=null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode peek = stack.peek();
            if(peek.right != null && lastVisited != peek.right) {
                cur = peek.right;
            } else {
                lastVisited = stack.pop();
            }
        }
        return result;
    }
    public static List<Integer> preOrderTransverseRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> result) {
        if(node != null) {
            result.add(node.val);
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = generateTestTree();
        List<Integer> result = preOrderTransverseRecursive(root);

        result.forEach(num -> System.out.print(num + " "));
    }
}
