package medium;

/**
 * @author Kedar Erande
 *
 * LC : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class PathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int LH = Math.max(0,helper(root.left));
        int RH = Math.max(0,helper(root.right));
        max = Math.max(max, root.val + LH + RH);
        return Math.max(LH,RH) + root.val;

    }

    public static void main(String[] args) {

    }
}
