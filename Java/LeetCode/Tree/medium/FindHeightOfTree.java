package medium;

/**
 * @author Kedar Erande
 */
class TreeHeight {
    int data;
    TreeHeight left;
    TreeHeight right;


    public TreeHeight(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class FindHeightOfTree {
    TreeHeight root;
    int LH;
    int RH;

    public FindHeightOfTree() {
        root = null;
    }


    public int findHeightOfTheBinaryTree(TreeHeight node) {
        if (node == null)
            return 0;
        LH = findHeightOfTheBinaryTree(node.left);
        RH = findHeightOfTheBinaryTree(node.right);

        return Math.max(LH, RH) + 1;

    }

    public static void main(String[] args) {
        FindHeightOfTree findHeightOfTree = new FindHeightOfTree();
        findHeightOfTree.root = new TreeHeight(1);
        findHeightOfTree.root.left = new TreeHeight(2);
        findHeightOfTree.root.right = new TreeHeight(3);
        findHeightOfTree.root.right.left = new TreeHeight(4);
        findHeightOfTree.root.right.right = new TreeHeight(5);

        //find the height the
        System.out.println(findHeightOfTree.findHeightOfTheBinaryTree(findHeightOfTree.root));


    }
}
