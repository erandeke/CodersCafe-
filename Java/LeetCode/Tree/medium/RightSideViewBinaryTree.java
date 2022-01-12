package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kedar Erande
 * <p>
 * //Iterative way :
 */


class TreeX {
    int val;
    TreeX left;
    TreeX right;

    TreeX(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class RightSideViewBinaryTree {
    TreeX root;

    public RightSideViewBinaryTree() {

        this.root = null;
    }

    public List<Integer> printRightSideViewBinaryTree(TreeX root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeX> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeX curr = queue.poll();
                if (size == 0) {
                    res.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        RightSideViewBinaryTree right = new RightSideViewBinaryTree();
        right.root = new TreeX(1);
        right.root.left = new TreeX(2);
        right.root.right = new TreeX(3);
        right.root.left.left = new TreeX(4);
        right.root.left.right = new TreeX(5);
        right.root.left.right.left = new TreeX(6);
        right.root.right.right = new TreeX(7);
        List<Integer> list = right.printRightSideViewBinaryTree(right.root);
        System.out.println(list);

    }

}
