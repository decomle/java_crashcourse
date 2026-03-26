package test.dsa.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
