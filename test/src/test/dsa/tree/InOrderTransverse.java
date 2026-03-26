package test.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// One type of DFS (Depth-First Search)
// Problem that it solve: validate BST
public class InOrderTransverse {
    public static List<Integer> inorderTransverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static List<Integer> recursiveInorderTransverse(TreeNode root) {
        return inorderTransverse(root, new ArrayList<>());
    }

    private static List<Integer> inorderTransverse(TreeNode node, List<Integer> result) {
        if(node == null) {
            return result;
        }
        inorderTransverse(node.left, result);
        result.add(node.val);
        inorderTransverse(node.right, result);

        return result;
    }

    private static TreeNode generateSampleTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(20);

        return  root;
    }

    public static void main(String[] args) {
        TreeNode root = generateSampleTree();
        for(Integer num: recursiveInorderTransverse(root)) {
            System.out.println(num + " ");
        }
    }
}
