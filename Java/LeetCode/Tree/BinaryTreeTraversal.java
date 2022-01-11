/**
 * @author Kedar Erande
 * Tree traversal : TC is O(n) and space is O(h)
 */
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

}

public class BinaryTreeTraversal {
    Node root;

    public BinaryTreeTraversal() {
        root = null;
    }

    void performInorder(Node node) {
        if (node == null)
            return;
        performInorder(node.left);
        System.out.println(node.data + "<----Result for Inorder");
        performInorder(node.right);

    }

    void performPreorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.data + "<---- Result for pre-order");
        performPreorder(node.left);
        performPreorder(node.right);

    }

    void performPostOrder(Node node) {
        if (node == null)
            return;
        performPostOrder(node.left);
        performPostOrder(node.right);
        System.out.println(node.data + "<---- Result for post-order");

    }

    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        binaryTreeTraversal.root = new Node(1);
        binaryTreeTraversal.root.left = new Node(2);
        binaryTreeTraversal.root.right = new Node(3);
        binaryTreeTraversal.root.left.left = new Node(4);
        binaryTreeTraversal.root.left.right = new Node(5);

        //inorder
        binaryTreeTraversal.performInorder(binaryTreeTraversal.root);

        //postorder
        binaryTreeTraversal.performPostOrder(binaryTreeTraversal.root);

        //preorder
        binaryTreeTraversal.performPreorder(binaryTreeTraversal.root);
    }
}
