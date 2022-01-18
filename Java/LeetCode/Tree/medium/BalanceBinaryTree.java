package medium;

/**
 * @author Kedar Erande
 */

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

}

public class BalanceBinaryTree {
    Node root;

    public BalanceBinaryTree() {
        root = null;
    }

    public boolean isTreeBalanced(Node root) {
        return checkHeightOfTree(root) != -1;
    }

    public int checkHeightOfTree(Node root) {
        if (root == null)
            return 0;
        int lHeight = checkHeightOfTree(root.left);
        if(lHeight == -1)
            return -1;
        int rHeight = checkHeightOfTree(root.right);
        if(rHeight==-1)
            return  -1;
        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }
        return Math.max(lHeight, rHeight) + 1;

    }

    public static void main(String[] args) {
        BalanceBinaryTree balanceBinaryTree = new BalanceBinaryTree();
        balanceBinaryTree.root = new Node(1);
        balanceBinaryTree.root.left = new Node(2);
        balanceBinaryTree.root.right = new Node(2);
        balanceBinaryTree.root.left.left = new Node(3);
        //left.right
        balanceBinaryTree.root.right.right = new Node(3);
        balanceBinaryTree.root.left.left.left = new Node(4);
        balanceBinaryTree.root.right.right.right = new Node(4);
        System.out.println(balanceBinaryTree.isTreeBalanced(balanceBinaryTree.root));


    }
}
