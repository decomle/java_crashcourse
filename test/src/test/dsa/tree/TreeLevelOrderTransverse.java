package test.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrderTransverse {

    private static TreeNode generateTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(11);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    // This is BFS (Breath-First Search)
    // Problems: Find shortest path in graph
    private static List<List<Integer>> treeLevelOrderTransverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int qSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();
            while(qSize > 0) {
                TreeNode node = queue.poll();
                qSize--;
                currentLevel.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null)  {
                    queue.add(node.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();

        List<List<Integer>> result = treeLevelOrderTransverse(root);

        for(List<Integer> lv: result) {
            lv.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        }
    }
}
