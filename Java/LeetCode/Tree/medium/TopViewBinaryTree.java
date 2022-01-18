package medium;

import java.util.*;

/**
 * @author Kedar Erande
 */
class TopView {
    int val;
    TopView left;
    TopView right;

    public TopView(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}

class PairTop {
    TopView root;
    int vertical;
    int horizontal;

    public PairTop(TopView root, int vertical, int horizontal) {
        this.root = root;
        this.vertical = vertical;
        this.horizontal = horizontal;

    }
}


public class TopViewBinaryTree {
    TopView root;

    public TopViewBinaryTree() {
        root = null;
    }

    public List<Integer> findTopView(TopView root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<PairTop> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            queue.offer(new PairTop(root, 0, 0));

        }
        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {

            PairTop p = queue.remove();

            min = Math.min(min, p.vertical);
            max = Math.max(max, p.vertical);

            if (!map.containsKey(p.vertical))
                map.put(p.vertical, p.root.val);

            if (p.root.left != null)
                queue.offer(new PairTop(p.root.left, p.vertical - 1, p.horizontal + 1));
            if (p.root.right != null)
                queue.offer(new PairTop(p.root.right, p.vertical + 1, p.horizontal + 1));


        }
        for (int i = min; i <= max; i++) {
            list.add(map.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        TopViewBinaryTree topViewBinaryTree = new TopViewBinaryTree();
        topViewBinaryTree.root = new TopView(1);
        topViewBinaryTree.root.left = new TopView(2);
        topViewBinaryTree.root.right = new TopView(3);
        topViewBinaryTree.root.left.left = new TopView(4);
        topViewBinaryTree.root.left.right = new TopView(5);
        topViewBinaryTree.root.right.right = new TopView(7);
        List<Integer> ans = topViewBinaryTree.findTopView(topViewBinaryTree.root);
        System.out.println(ans);
    }

}
