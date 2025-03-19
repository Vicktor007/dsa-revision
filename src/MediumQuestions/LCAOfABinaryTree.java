package MediumQuestions;


public class LCAOfABinaryTree {
    /**
     Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)."
     */
//    Time 0(h) space o(1)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or root is either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for the left and right subtrees
        int small = Math.min( p.val, q.val);
        int large = Math.max( p.val, q.val);
        while (root != null){
            if (root.val > large){
                root = root.left;
            } else if (root.val < small) {
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }
}
