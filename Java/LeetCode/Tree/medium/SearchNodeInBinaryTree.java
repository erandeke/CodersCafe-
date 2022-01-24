package medium;

/**
 * @author Kedar Erande
 */
class TreeSearchDS {

    int data;
    TreeSearchDS left;
    TreeSearchDS right;

    public TreeSearchDS(int data) {
        this.data = data;
        this.left = this.right = null;
    }


}


public class SearchNodeInBinaryTree {
    TreeSearchDS root;

    public SearchNodeInBinaryTree() {
        root = null;
    }

    public boolean searchInBT(TreeSearchDS root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        boolean res1 = searchInBT(root.left, data);
        if (res1) return true;
        boolean res2 = searchInBT(root.right, data);
        return res2;

    }

    public static void main(String[] args) {
        SearchNodeInBinaryTree sbt = new SearchNodeInBinaryTree();
        sbt.root = new TreeSearchDS(1);
        sbt.root.left = new TreeSearchDS(2);
        sbt.root.right = new TreeSearchDS(3);
        sbt.root.right.left = new TreeSearchDS(6);
        sbt.root.left.left = new TreeSearchDS(4);
        sbt.root.left.right = new TreeSearchDS(5);
        boolean root = sbt.searchInBT(sbt.root, 6);
        System.out.println(root);
    }


}

