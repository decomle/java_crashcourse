package test.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class AverageLevel {
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

    public static List<Double> averageOfLevels(TreeNode tree) {
        List<Double> result = new ArrayList<>();

        if(tree == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()) {
            int qSize = queue.size(), len = qSize;
            double sum = 0d;

            while(qSize > 0) {
                TreeNode node = queue.poll();
                qSize--;

                sum+=node.val;
                if(node.right!=null) {
                    queue.offer(node.right);
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                }
            }
            result.add(sum/len);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = generateTree();

        averageOfLevels(tree).forEach(num -> System.out.print(num + " "));
    }
}
