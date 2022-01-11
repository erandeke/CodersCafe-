package medium;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderTraversal {
    TreeNode root;

    public LevelOrderTraversal() {
        this.root = null;
    }

    public List<List<Integer>> getTheWrappedList() {
        List<List<Integer>> wrappedList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return wrappedList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrappedList.add(subList);
        }
        return wrappedList;


    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.root = new TreeNode(1);
        levelOrderTraversal.root.left = new TreeNode(2);
        levelOrderTraversal.root.right = new TreeNode(3);
        levelOrderTraversal.root.left.left = new TreeNode(4);
        levelOrderTraversal.root.left.right = new TreeNode(5);
        List<List<Integer>> list = levelOrderTraversal.getTheWrappedList();
        System.out.println(list);

    }
}
