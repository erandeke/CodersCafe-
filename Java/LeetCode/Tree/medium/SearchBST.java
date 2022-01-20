package medium;

/**
 * @author Kedar Erande
 * Program to find the node in binary search tree
 * <p>
 * The structre of binary search tree is L < N < R
 * Time complexity : O(logn)
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
